package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1746 extends LeetcodeProblem {

    int maxSumAfterOperation(int[] _nums) {
        int len = _nums.length;

        // 1. the element _nums[i] squared itself might be the biggest sum of subarray itself;

        int[][] dp = new int[len][2];
        dp[0][0] = _nums[0];
        dp[0][1] = _nums[0] * _nums[0];
        int maxSum = dp[0][1];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + _nums[i], _nums[i]);
            dp[i][1] = Math.max(_nums[i] * _nums[i], Math.max(dp[i - 1][0] + _nums[i] * _nums[i], dp[i - 1][1] + _nums[i]));
            maxSum = Math.max(maxSum, dp[i][1]);
        }
        return maxSum;
    }

}
