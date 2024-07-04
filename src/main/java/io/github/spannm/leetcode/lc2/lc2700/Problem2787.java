package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2787. Ways to Express an Integer as Sum of Powers.
 */
class Problem2787 extends LeetcodeProblem {

    int numberOfWays(int n, int x) {
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[n + 1][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            long k = (long) Math.pow(i, x);
            for (int j = 0; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (k <= j) {
                    f[i][j] = (f[i][j] + f[i - 1][j - (int) k]) % mod;
                }
            }
        }
        return f[n][n];
    }

}
