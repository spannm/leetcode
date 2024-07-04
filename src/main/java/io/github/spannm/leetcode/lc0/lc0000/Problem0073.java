package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/set-matrix-zeroes/">73. Set Matrix Zeroes </a>.
 */
class Problem0073 extends LeetcodeProblem {

    void setZeroes(int[][] _matrix) {
        int rows = _matrix.length;
        if (rows == 0) {
            return;
        }
        int cols = _matrix[0].length;
        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (_matrix[r][c] == 0) {
                    row[r] = true;
                    col[c] = true;
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (row[r] && col[c]) {
                    for (int k = 0; k < rows; k++) {
                        _matrix[k][c] = 0;
                    }
                    for (int k = 0; k < cols; k++) {
                        _matrix[r][k] = 0;
                    }
                }
            }
        }
    }

}
