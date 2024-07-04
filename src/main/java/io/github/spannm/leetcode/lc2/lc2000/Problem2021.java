package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeMap;

/**
 * 2021. Brightest Position on Street.
 */
class Problem2021 extends LeetcodeProblem {

    int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (var x : lights) {
            int l = x[0] - x[1];
            int r = x[0] + x[1];
            d.merge(l, 1, Integer::sum);
            d.merge(r + 1, -1, Integer::sum);
        }
        int ans = 0;
        int s = 0;
        int mx = 0;
        for (var x : d.entrySet()) {
            int v = x.getValue();
            s += v;
            if (mx < s) {
                mx = s;
                ans = x.getKey();
            }
        }
        return ans;
    }

}
