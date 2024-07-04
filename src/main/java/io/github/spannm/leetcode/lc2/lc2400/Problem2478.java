package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2478. Number of Beautiful Partitions.
 */
class Problem2478 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int beautifulPartitions(String s, int k, int minLength) {
        int n = s.length();
        if (!prime(s.charAt(0)) || prime(s.charAt(n - 1))) {
            return 0;
        }
        int[][] f = new int[n + 1][k + 1];
        int[][] g = new int[n + 1][k + 1];
        f[0][0] = 1;
        g[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i >= minLength && !prime(s.charAt(i - 1)) && (i == n || prime(s.charAt(i)))) {
                if (k >= 0) {
                    System.arraycopy(g[i - minLength], 0, f[i], 1, k);
                }
            }
            for (int j = 0; j <= k; j++) {
                g[i][j] = (g[i - 1][j] + f[i][j]) % MOD;
            }
        }
        return f[n][k];
    }

    private boolean prime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

}
