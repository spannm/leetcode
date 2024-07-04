package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 2015. Average Height of Buildings in Each Segment.
 */
class Problem2015 extends LeetcodeProblem {

    int[][] averageHeightOfBuildings(int[][] buildings) {
        TreeMap<Integer, Integer> height = new TreeMap<>();
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (var v : buildings) {
            int s = v[0];
            int e = v[1];
            int h = v[2];
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            cnt.put(e, cnt.getOrDefault(e, 0) - 1);
            height.put(s, height.getOrDefault(s, 0) + h);
            height.put(e, height.getOrDefault(e, 0) - h);
        }
        int i = 0;
        int h = 0;
        int n = 0;
        List<int[]> res = new ArrayList<>();
        for (int j : cnt.keySet()) {
            if (n > 0) {
                int[] t = new int[] {i, j, h / n};
                int k = res.size() - 1;
                if (k >= 0 && res.get(k)[1] == i && res.get(k)[2] == t[2]) {
                    res.get(k)[1] = j;
                } else {
                    res.add(t);
                }
            }
            h += height.get(j);
            n += cnt.get(j);
            i = j;
        }
        int[][] ans = new int[res.size()][3];
        for (i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

}
