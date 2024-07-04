package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1278. Palindrome Partitioning III.
 */
class Problem1278 extends LeetcodeProblem {

    int palindromePartition(String _s, int _k) {
        int n = _s.length();
        int[][] g = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                g[i][j] = _s.charAt(i) != _s.charAt(j) ? 1 : 0;
                if (i + 1 < j) {
                    g[i][j] += g[i + 1][j - 1];
                }
            }
        }
        int[][] f = new int[n + 1][_k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, _k); j++) {
                if (j == 1) {
                    f[i][j] = g[0][i - 1];
                } else {
                    f[i][j] = 10000;
                    for (int h = j - 1; h < i; h++) {
                        f[i][j] = Math.min(f[i][j], f[h][j - 1] + g[h][i - 1]);
                    }
                }
            }
        }
        return f[n][_k];
    }

}
