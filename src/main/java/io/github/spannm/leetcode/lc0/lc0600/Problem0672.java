package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0672 extends LeetcodeProblem {

    int flipLights(int _n, int _m) {
        if (_m < 1) {
            return 1;
        }
        int[][] dp = new int[_m][_n];
        for (int i = 0; i < _m; i++) {
            for (int j = 0; j < _n; j++) {
                if (j == 0) {
                    dp[i][j] = 2;
                } else if (i == 0 && j == 1) {
                    dp[i][j] = 3;
                } else if (i == 0) {
                    dp[i][j] = 4;
                } else if (i == 1 && j == 1) {
                    dp[i][j] = 4;
                } else if (i == 1 && j > 1) {
                    dp[i][j] = 7;
                } else if (j == 1) {
                    dp[i][j] = 4;
                } else if (i == 1) {
                    dp[i][j] = 7;
                } else {
                    dp[i][j] = 8;
                }
            }
        }
        return dp[_m - 1][_n - 1];
    }

}
