package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0498 extends LeetcodeProblem {

    int[] findDiagonalOrder(int[][] _matrix) {
        if (_matrix == null || _matrix.length == 0) {
            return new int[0];
        }
        int nbRows = _matrix.length;
        int nbCols = _matrix[0].length;
        int[] result = new int[nbRows * nbCols];
        int d = 1;
        int i = 0;
        int j = 0;
        for (int k = 0; k < nbRows * nbCols;) {
            result[k++] = _matrix[i][j];
            i -= d;
            j += d;

            if (i >= nbRows) {
                i = nbRows - 1;
                j += 2;
                d = -d;
            }
            if (j >= nbCols) {
                j = nbCols - 1;
                i += 2;
                d = -d;
            }
            if (i < 0) {
                i = 0;
                d = -d;
            }
            if (j < 0) {
                j = 0;
                d = -d;
            }
        }
        return result;
    }

}
