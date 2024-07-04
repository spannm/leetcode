package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 730. Count Different Palindromic Subsequences.
 */
class Problem0730 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int countPalindromicSubsequences(String _s) {
        int len = _s.length();
        long[][][] dp = new long[len][len][4];
        for (int i = 0; i < len; i++) {
            dp[i][i][_s.charAt(i) - 'a'] = 1;
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i + l <= len; i++) {
                int j = i + l - 1;
                for (char c = 'a'; c <= 'd'; c++) {
                    int k = c - 'a';
                    if (_s.charAt(i) == c && _s.charAt(j) == c) {
                        dp[i][j][k] = 2 + dp[i + 1][j - 1][0] + dp[i + 1][j - 1][1]
                            + dp[i + 1][j - 1][2] + dp[i + 1][j - 1][3];
                        dp[i][j][k] %= MOD;
                    } else if (_s.charAt(i) == c) {
                        dp[i][j][k] = dp[i][j - 1][k];
                    } else if (_s.charAt(j) == c) {
                        dp[i][j][k] = dp[i + 1][j][k];
                    } else {
                        dp[i][j][k] = dp[i + 1][j - 1][k];
                    }
                }
            }
        }
        long ans = 0;
        for (int k = 0; k < 4; k++) {
            ans += dp[0][len - 1][k];
        }
        return (int) (ans % MOD);
    }

}
