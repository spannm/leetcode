package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1246. Palindrome Removal.
 */
class Problem1246 extends LeetcodeProblem {

    int minimumMoves(int[] _arr) {
        int n = _arr.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (i + 1 == j) {
                    f[i][j] = _arr[i] == _arr[j] ? 1 : 2;
                } else {
                    int t = _arr[i] == _arr[j] ? f[i + 1][j - 1] : 1 << 30;
                    for (int k = i; k < j; k++) {
                        t = Math.min(t, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = t;
                }
            }
        }
        return f[0][n - 1];
    }

}
