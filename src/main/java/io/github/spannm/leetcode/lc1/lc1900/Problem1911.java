package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1911. Maximum Alternating Subsequence Sum.
 */
class Problem1911 extends LeetcodeProblem {

    long maxAlternatingSum(int[] nums) {
        long f = 0;
        long g = 0;
        for (int x : nums) {
            long ff = Math.max(g - x, f);
            long gg = Math.max(f + x, g);
            f = ff;
            g = gg;
        }
        return Math.max(f, g);
    }

}
