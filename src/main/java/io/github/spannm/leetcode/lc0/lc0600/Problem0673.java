package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/number-of-longest-increasing-subsequence/"> 673. Number of Longest Increasing
 * Subsequence</a>.
 */
class Problem0673 extends LeetcodeProblem {

    int findNumberOfLIS(final int[] _nums) {
        final int len = _nums.length;
        int[] dp = new int[len];
        int[] counts = new int[len];
        dp[0] = 1;
        counts[0] = 1;
        int result = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            counts[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (_nums[j] >= _nums[i]) {
                    continue;
                }
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    counts[i] = counts[j];
                } else if (dp[i] == dp[j] + 1) {
                    counts[i] += counts[j];
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (max < dp[i]) {
                result = counts[i];
                max = dp[i];
            } else if (max == dp[i]) {
                result += counts[i];
            }
        }

        dp = null;
        counts = null;
        System.gc();

        return result;
    }

}
