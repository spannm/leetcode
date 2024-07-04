package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/01-matrix/">542. 01 Matrix</a>.
 */
class Problem0994 extends LeetcodeProblem {

    int[][] updateMatrix(int[][] _matrix) {

        int rowCount = _matrix.length;
        int colCount = _matrix[0].length;
        int inf = rowCount + colCount;

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (_matrix[r][c] == 0) {
                    continue;
                }
                int top = inf;
                int left = inf;
                if (r - 1 >= 0) {
                    top = _matrix[r - 1][c];
                }
                if (c - 1 >= 0) {
                    left = _matrix[r][c - 1];
                }
                _matrix[r][c] = Math.min(top, left) + 1;
            }
        }

        for (int r = rowCount - 1; r >= 0; r--) {
            for (int c = colCount - 1; c >= 0; c--) {
                if (_matrix[r][c] == 0) {
                    continue;
                }
                int bottom = inf;
                int right = inf;
                if (r + 1 < rowCount) {
                    bottom = _matrix[r + 1][c];
                }
                if (c + 1 < colCount) {
                    right = _matrix[r][c + 1];
                }
                _matrix[r][c] = Math.min(_matrix[r][c], Math.min(bottom, right) + 1);
            }
        }
        return _matrix;
    }

}
