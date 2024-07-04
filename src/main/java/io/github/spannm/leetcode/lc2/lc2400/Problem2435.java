package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2435. Paths in Matrix Whose Sum Is Divisible by K.
 */
class Problem2435 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int s = 0; s < k; s++) {
                    int t = (s - grid[i][j] % k + k) % k;
                    if (i > 0) {
                        dp[i][j][s] += dp[i - 1][j][t];
                    }
                    if (j > 0) {
                        dp[i][j][s] += dp[i][j - 1][t];
                    }
                    dp[i][j][s] %= MOD;
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }

}
