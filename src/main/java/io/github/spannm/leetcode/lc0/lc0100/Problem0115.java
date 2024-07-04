package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/distinct-subsequences/">115. Distinct Subsequences</a>.
 */
class Problem0115 extends LeetcodeProblem {

    int numDistinct(String _s, String _t) {
        final int slen = _s.length();
        final int tlen = _t.length();

        int[][] dp = new int[slen + 1][tlen + 1];

        char[] schars = _s.toCharArray();
        char[] tchars = _t.toCharArray();

        for (int s = 0; s <= slen; s++) {
            dp[s][0] = 1;
        }

        for (int t = 1; t <= tlen; t++) {
            dp[0][t] = 0;
        }

        for (int s = 1; s <= slen; s++) {
            for (int t = 1; t <= tlen; t++) {
                if (schars[s - 1] == tchars[t - 1]) {
                    dp[s][t] = dp[s - 1][t] + dp[s - 1][t - 1];
                } else {
                    dp[s][t] = dp[s - 1][t];
                }
            }
        }

        int result = dp[slen][tlen];

        dp = null;
        schars = null;
        tchars = null;

        return result;
    }

}
