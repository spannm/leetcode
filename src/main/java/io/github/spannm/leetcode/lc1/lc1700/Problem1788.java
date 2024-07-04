package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1788. Maximize the Beauty of the Garden.
 */
class Problem1788 extends LeetcodeProblem {

    int maximumBeauty(int[] flowers) {
        int n = flowers.length;
        int[] s = new int[n + 1];
        Map<Integer, Integer> d = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int v = flowers[i];
            if (d.containsKey(v)) {
                ans = Math.max(ans, s[i] - s[d.get(v) + 1] + v * 2);
            } else {
                d.put(v, i);
            }
            s[i + 1] = s[i] + Math.max(v, 0);
        }
        return ans;
    }

}
