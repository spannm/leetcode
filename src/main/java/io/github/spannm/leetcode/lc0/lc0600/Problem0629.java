package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0629 extends LeetcodeProblem {

    int kInversePairs(int _n, int _k) {
        int mod = 1000000007;
        if (_k > _n * (_n - 1) / 2 || _k < 0) {
            return 0;
        } else if (_k == 0 || _k == _n * (_n - 1) / 2) {
            return 1;
        }
        long[][] dp = new long[_n + 1][_k + 1];
        dp[2][0] = 1;
        dp[2][1] = dp[2][0];
        for (int i = 3; i <= _n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(_k, i * (i - 1) / 2); j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        int result = (int) dp[_n][_k];
        dp = null;
        return result;
    }

}
