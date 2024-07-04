package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1130. Minimum Cost Tree From Leaf Values.
 */
class Problem1130 extends LeetcodeProblem {

    int mctFromLeafValues(int[] _arr) {
        int n = _arr.length;
        int[][] f = new int[n][n];
        int[][] g = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            g[i][i] = _arr[i];
            for (int j = i + 1; j < n; j++) {
                g[i][j] = Math.max(g[i][j - 1], _arr[j]);
                f[i][j] = 1 << 30;
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + g[i][k] * g[k + 1][j]);
                }
            }
        }
        return f[0][n - 1];
    }

}
