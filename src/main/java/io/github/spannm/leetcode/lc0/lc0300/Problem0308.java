package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0308 extends LeetcodeProblem {

    static class NumMatrix {
        private final int[][] nums;
        private final int[][] tree;
        private final int     height;
        private final int     width;

        NumMatrix(int[][] _matrix) {
            height = _matrix.length;
            width = _matrix[0].length;
            nums = new int[height][width];
            tree = new int[height + 1][width + 1];
            if (width == 0) {
                return;
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    update(i, j, _matrix[i][j]);
                }
            }
        }

        void update(int _rowIndex, int _colIndex, int _newVal) {
            if (height == 0 || width == 0) {
                return;
            }
            int delta = _newVal - nums[_rowIndex][_colIndex];
            nums[_rowIndex][_colIndex] = _newVal;
            for (int i = _rowIndex + 1; i <= height; i += i & -i) {
                for (int j = _colIndex + 1; j <= width; j += j & -j) {
                    tree[i][j] += delta;
                }
            }
        }

        int sumRegion(int _row1, int _col1, int _row2, int _col2) {
            if (height == 0 || width == 0) {
                return 0;
            }
            return sum(_row2 + 1, _col2 + 1) + sum(_row1, _col1) - sum(_row1, _col2 + 1) - sum(
                _row2 + 1, _col1);
        }

        private int sum(int _row, int _col) {
            int sum = 0;
            for (int i = _row; i > 0; i -= i & -i) {
                for (int j = _col; j > 0; j -= j & -j) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }
    }

}
