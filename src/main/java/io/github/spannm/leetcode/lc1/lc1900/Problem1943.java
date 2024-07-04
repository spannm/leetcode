package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1943. Describe the Painting.
 */
class Problem1943 extends LeetcodeProblem {

    List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> d = new TreeMap<>();
        for (int[] e : segments) {
            int l = e[0];
            int r = e[1];
            int c = e[2];
            d.put(l, d.getOrDefault(l, 0L) + c);
            d.put(r, d.getOrDefault(r, 0L) - c);
        }
        List<List<Long>> ans = new ArrayList<>();
        long i = 0;
        long j = 0;
        long cur = 0;
        for (Map.Entry<Integer, Long> e : d.entrySet()) {
            if (Objects.equals(e.getKey(), d.firstKey())) {
                i = e.getKey();
            } else {
                j = e.getKey();
                if (cur > 0) {
                    ans.add(Arrays.asList(i, j, cur));
                }
                i = j;
            }
            cur += e.getValue();
        }
        return ans;
    }

}
