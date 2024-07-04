package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1955. Count Number of Special Subsequences.
 */
class Problem1955 extends LeetcodeProblem {

    int countSpecialSubsequences(int[] nums) {
        final int mod = (int) 1e9 + 7;
        int n = nums.length;
        int[] f = new int[3];
        f[0] = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                f[0] = (2 * f[0] % mod + 1) % mod;
            } else if (nums[i] == 1) {
                f[1] = (f[0] + 2 * f[1] % mod) % mod;
            } else {
                f[2] = (f[1] + 2 * f[2] % mod) % mod;
            }
        }
        return f[2];
    }

}
