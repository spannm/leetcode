package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/longest-arithmetic-subsequence/">1027. Longest Arithmetic Subsequence</a>.
 */
class Problem1027 extends LeetcodeProblem {

    int longestArithSeqLength(int[] _nums) {
        final int len = _nums.length;
        final int[][] dp = new int[len][1001];
        int max = 0;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int diff = _nums[j] - _nums[i] + 500;
                dp[i][diff] = dp[j][diff] + 1;
                max = Math.max(max, dp[i][diff]);
            }
        }
        return max + 1;
    }

}
