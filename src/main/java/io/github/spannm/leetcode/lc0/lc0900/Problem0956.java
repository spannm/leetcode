package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/tallest-billboard/">956. Tallest Billboard</a>.
 */
class Problem0956 extends LeetcodeProblem {

    final int tallestBillboard(final int[] _rods) {
        final int sum = Arrays.stream(_rods).sum();

        final int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int rod : _rods) {
            final int[] prev = dp.clone();

            for (int diff = 0; diff <= sum - rod; diff++) {
                if (prev[diff] >= 0) {
                    dp[diff + rod] = Math.max(dp[diff + rod], prev[diff]);
                    dp[Math.abs(diff - rod)] = Math.max(dp[Math.abs(diff - rod)], prev[diff] + Math.min(diff, rod));
                }
            }
        }

        return dp[0];
    }

}
