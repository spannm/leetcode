package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 566. Reshape the Matrix.
 */
class Problem0566 extends LeetcodeProblem {

    int[][] matrixReshape(int[][] _mat, int _r, int _c) {
        int nbRows = _mat.length;
        int nbCols = _mat[0].length;
        if (nbRows * nbCols != _r * _c) {
            return _mat;
        }
        int[][] res = new int[_r][_c];
        for (int i = 0; i < nbRows * nbCols; i++) {
            res[i / _c][i % _c] = _mat[i / nbCols][i % nbCols];
        }
        return res;
    }

}
