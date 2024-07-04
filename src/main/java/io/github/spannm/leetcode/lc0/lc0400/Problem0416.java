package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0416 extends LeetcodeProblem {

    boolean canPartition(int[] _nums) {
        int sum = 0;
        for (int num : _nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        sum /= 2;

        int len = _nums.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (boolean[] element : dp) {
            Arrays.fill(element, false);
        }

        dp[0][0] = true;

        for (int i = 1; i < len + 1; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= _nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - _nums[i - 1]];
                }
            }
        }

        return dp[len][sum];
    }

}
