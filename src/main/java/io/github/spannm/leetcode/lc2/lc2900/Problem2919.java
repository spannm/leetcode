package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2919. Minimum Increment Operations to Make Array Beautiful.
 */
class Problem2919 extends LeetcodeProblem {

    long minIncrementOperations(int[] nums, int k) {
        long f = 0;
        long g = 0;
        long h = 0;
        for (int x : nums) {
            long hh = Math.min(Math.min(f, g), h) + Math.max(k - x, 0);
            f = g;
            g = h;
            h = hh;
        }
        return Math.min(Math.min(f, g), h);
    }

}
