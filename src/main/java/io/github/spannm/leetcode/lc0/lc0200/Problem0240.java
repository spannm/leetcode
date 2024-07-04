package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0240 extends LeetcodeProblem {

    boolean searchMatrix(int[][] _matrix, int _target) {
        int nbRows = _matrix.length;
        int nbCols = _matrix[0].length;
        int x = 0;
        int y = nbCols - 1;
        while (x < nbRows && y >= 0) {
            if (_target == _matrix[x][y]) {
                return true;
            } else if (_target > _matrix[x][y]) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }

}
