package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1886 extends LeetcodeProblem {

    boolean findRotation(int[][] _mat, int[][] _target) {
        int m = _mat.length;
        int n = _mat[0].length;
        for (int i = 0; i < m; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (_mat[i][j] != _target[i][j]) {
                    break;
                }
            }
            if (j < n) {
                break;
            } else if (i == m - 1) {
                return true;
            }
        }

        for (int i = 0, k = n - 1; i < m; i++, k--) {
            int j = 0;
            for (; j < n; j++) {
                if (_mat[i][j] != _target[j][k]) {
                    break;
                }
            }
            if (j < n) {
                break;
            } else if (i == m - 1) {
                return true;
            }
        }
        int[][] rotated = new int[m][n];
        for (int i = 0, k = n - 1; i < m; i++, k--) {
            for (int j = 0; j < n; j++) {
                rotated[j][k] = _mat[i][j];
            }
        }

        for (int i = 0, k = n - 1; i < m; i++, k--) {
            int j = 0;
            for (; j < n; j++) {
                if (rotated[i][j] != _target[j][k]) {
                    break;
                }
            }
            if (j < n) {
                break;
            } else if (i == m - 1) {
                return true;
            }
        }
        int[][] rotated2 = new int[m][n];
        for (int i = 0, k = n - 1; i < m; i++, k--) {
            int j = 0;
            for (; j < n; j++) {
                rotated2[j][k] = rotated[i][j];
            }
        }

        for (int i = 0, k = n - 1; i < m; i++, k--) {
            int j = 0;
            for (; j < n; j++) {
                if (rotated2[i][j] != _target[j][k]) {
                    break;
                }
            }
            if (j < n) {
                break;
            } else if (i == m - 1) {
                return true;
            }
        }
        return false;
    }

}
