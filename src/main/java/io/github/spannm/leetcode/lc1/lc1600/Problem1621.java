package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1621. Number of Sets of K Non-Overlapping Line Segments.
 */
class Problem1621 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int numberOfSets(int n, int k) {
        int[][] f = new int[n + 1][k + 1];
        int[][] g = new int[n + 1][k + 1];
        f[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                f[i][j] = (f[i - 1][j] + g[i - 1][j]) % MOD;
                g[i][j] = g[i - 1][j];
                if (j > 0) {
                    g[i][j] += f[i - 1][j - 1];
                    g[i][j] %= MOD;
                    g[i][j] += g[i - 1][j - 1];
                    g[i][j] %= MOD;
                }
            }
        }
        return (f[n][k] + g[n][k]) % MOD;
    }

}
