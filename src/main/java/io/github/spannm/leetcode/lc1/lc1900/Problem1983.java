package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1983. Widest Pair of Indices With Equal Range Sum.
 */
class Problem1983 extends LeetcodeProblem {

    int widestPairOfIndices(int[] nums1, int[] nums2) {
        Map<Integer, Integer> d = new HashMap<>();
        d.put(0, -1);
        int n = nums1.length;
        int s = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            s += nums1[i] - nums2[i];
            if (d.containsKey(s)) {
                ans = Math.max(ans, i - d.get(s));
            } else {
                d.put(s, i);
            }
        }
        return ans;
    }

}
