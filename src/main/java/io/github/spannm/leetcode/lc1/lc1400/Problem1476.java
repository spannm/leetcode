package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1476 extends LeetcodeProblem {

    static class SubrectangleQueries {
        private final int[][] matrix;

        SubrectangleQueries(int[][] _rectangle) {
            matrix = _rectangle;
        }

        void updateSubrectangle(int _row1, int _col1, int _row2, int _col2, int _newValue) {
            for (int i = _row1; i <= _row2; i++) {
                for (int j = _col1; j <= _col2; j++) {
                    matrix[i][j] = _newValue;
                }
            }
        }

        int getValue(int _row, int _col) {
            return matrix[_row][_col];
        }
    }

}
