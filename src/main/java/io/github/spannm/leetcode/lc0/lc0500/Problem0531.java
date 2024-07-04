package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0531 extends LeetcodeProblem {

    int findLonelyPixel(char[][] _picture) {
        int nbRows = _picture.length;
        int nbCols = _picture[0].length;
        int count = 0;
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_picture[r][c] == 'B' && isLonely(r, c, _picture, nbRows, nbCols)) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isLonely(int _row, int _col, char[][] _picture, int _m, int _n) {
        for (int i = 0; i < _m; i++) {
            if (i != _row) {
                if (_picture[i][_col] == 'B') {
                    return false;
                }
            }
        }

        for (int j = 0; j < _n; j++) {
            if (j != _col) {
                if (_picture[_row][j] == 'B') {
                    return false;
                }
            }
        }
        return true;
    }

}
