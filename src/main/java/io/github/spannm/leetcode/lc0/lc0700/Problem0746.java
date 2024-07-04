package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">746. Min Cost Climbing Stairs</a>.
 */
class Problem0746 extends LeetcodeProblem {

    int minCostClimbingStairs(int[] _cost) {
        final int len = _cost.length;
        int[] dp = new int[len];
        dp[0] = _cost[0];
        dp[1] = _cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = _cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        int result = Math.min(dp[len - 1], dp[len - 2]);
        _cost = null;
        dp = null;
        return result;
    }

}
