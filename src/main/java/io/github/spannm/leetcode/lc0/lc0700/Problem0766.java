package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0766 extends LeetcodeProblem {

    boolean isToeplitzMatrix(int[][] _matrix) {
        int nbRows = _matrix.length;
        int nbCols = _matrix[0].length;
        int r = 0;
        int c = 0;
        int sameVal = _matrix[r][c];
        while (++r < nbRows && ++c < nbCols) {
            if (_matrix[r][c] != sameVal) {
                return false;
            }
        }

        for (r = 1, c = 0; r < nbRows; r++) {
            int tmpI = r;
            int tmpJ = c;
            sameVal = _matrix[r][c];
            while (++tmpI < nbRows && ++tmpJ < nbCols) {
                if (_matrix[tmpI][tmpJ] != sameVal) {
                    return false;
                }
            }
        }
        for (r = 0, c = 1; c < nbCols; c++) {
            int tmpc = c;
            int tmpr = r;
            sameVal = _matrix[tmpr][tmpc];
            while (++tmpr < nbRows && ++tmpc < nbCols) {
                if (_matrix[tmpr][tmpc] != sameVal) {
                    return false;
                }
            }
        }
        return true;
    }

}
