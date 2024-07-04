package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0311 extends LeetcodeProblem {

    int[][] multiply(int[][] _a, int[][] _b) {
        int nbRows = _a.length;
        int nbCols = _a[0].length;
        int p = _b[0].length;
        int[][] res = new int[nbRows][p];
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_a[r][c] != 0) {
                    for (int k = 0; k < p; k++) {
                        if (_b[c][k] != 0) {
                            res[r][k] += _a[r][c] * _b[c][k];
                        }
                    }
                }
            }
        }
        return res;
    }

}
