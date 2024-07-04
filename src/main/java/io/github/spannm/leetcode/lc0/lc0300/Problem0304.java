package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0304 extends LeetcodeProblem {

    static class NumMatrix {

        private final int[][] tot;

        NumMatrix(int[][] _matrix) {
            int nbRows = _matrix.length;
            int nbCols = _matrix[0].length;
            tot = new int[nbRows + 1][nbCols + 1];
            for (int r = 0; r < nbRows; r++) {
                for (int c = 0; c < nbCols; c++) {
                    tot[r + 1][c + 1] =
                        _matrix[r][c] + tot[r + 1][c] + tot[r][c + 1] - tot[r][c];
                }
            }
        }

        int sumRegion(int _row1, int _col1, int _row2, int _col2) {
            return tot[_row2 + 1][_col2 + 1] - tot[_row2 + 1][_col1] - tot[_row1][_col2 + 1]
                + tot[_row1][_col1];
        }

    }

}
