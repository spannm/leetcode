package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold.
 */
class Problem1292 extends LeetcodeProblem {

    private int     nbRows;
    private int     nbCols;
    private int     threshold;
    private int[][] s;

    int maxSideLength(int[][] _mat, int _threshold) {
        nbRows = _mat.length;
        nbCols = _mat[0].length;
        threshold = _threshold;
        s = new int[nbRows + 1][nbCols + 1];
        for (int r = 1; r <= nbRows; r++) {
            for (int c = 1; c <= nbCols; c++) {
                s[r][c] = s[r - 1][c] + s[r][c - 1] - s[r - 1][c - 1] + _mat[r - 1][c - 1];
            }
        }
        int l = 0;
        int r = Math.min(nbRows, nbCols);
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int _k) {
        for (int r = 0; r < nbRows - _k + 1; r++) {
            for (int c = 0; c < nbCols - _k + 1; c++) {
                if (s[r + _k][c + _k] - s[r][c + _k] - s[r + _k][c] + s[r][c] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

}
