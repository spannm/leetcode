package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/profitable-schemes/">879. Profitable Schemes</a>.
 */
class Problem0879 extends LeetcodeProblem {

    int profitableSchemes(int _memberCount, int _minProfit, int[] _group, int[] _profit) {
        final int mod = (int) 1E9 + 7;
        final int len = _group.length;

        final int[][][] dp = new int[len + 1][_memberCount + 1][_minProfit + 1];
        dp[0][0][0] = 1;

        for (int g = 1; g <= len; g++) {
            int members = _group[g - 1];
            int earned = _profit[g - 1];
            for (int m = 0; m <= _memberCount; m++) {
                for (int p = 0; p <= _minProfit; p++) {
                    if (m < members) {
                        dp[g][m][p] = dp[g - 1][m][p];
                    } else {
                        dp[g][m][p] = (dp[g - 1][m][p] + dp[g - 1][m - members][Math.max(0, p - earned)]) % mod;
                    }
                }
            }
        }

        int sum = 0;

        for (int m = 0; m <= _memberCount; m++) {
            sum = (sum + dp[len][m][_minProfit]) % mod;
        }
        return sum;
    }

}
