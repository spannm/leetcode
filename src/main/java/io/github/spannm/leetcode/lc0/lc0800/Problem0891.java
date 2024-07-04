package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 891. Sum of Subsequence Widths.
 */
class Problem0891 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int sumSubseqWidths(int[] _nums) {
        Arrays.sort(_nums);
        long ans = 0;
        long p = 1;
        int n = _nums.length;
        for (int i = 0; i < n; i++) {
            ans = (ans + (_nums[i] - _nums[n - i - 1]) * p + MOD) % MOD;
            p = (p << 1) % MOD;
        }
        return (int) ans;
    }

}
