package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1277 extends LeetcodeProblem {

    int countSquares(int[][] _matrix) {
        int m = _matrix.length;
        int n = _matrix[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (_matrix[i][j] > 0 && i > 0 && j > 0) {
                    _matrix[i][j] = Math.min(_matrix[i - 1][j - 1], Math.min(_matrix[i - 1][j], _matrix[i][j - 1])) + 1;
                }
                count += _matrix[i][j];
            }
        }
        return count;
    }

}
