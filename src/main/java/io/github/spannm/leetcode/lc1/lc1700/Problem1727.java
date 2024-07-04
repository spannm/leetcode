package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1727 extends LeetcodeProblem {

    int largestSubmatrix(int[][] _matrix) {
        final int nbRows = _matrix.length;
        final int nbCols = _matrix[0].length;
        for (int r = 1; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_matrix[r][c] != 0) {
                    _matrix[r][c] = _matrix[r - 1][c] + 1;
                }
            }
        }
        int count = 0;
        for (int[] row : _matrix) {
            Arrays.sort(row);
            for (int c = 1; c <= nbCols; c++) {
                count = Math.max(count, c * row[nbCols - c]);
            }
        }
        return count;
    }

}
