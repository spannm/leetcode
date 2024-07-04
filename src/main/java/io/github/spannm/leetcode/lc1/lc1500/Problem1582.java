package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1582 extends LeetcodeProblem {

    int numSpecial(int[][] _mat) {
        int count = 0;
        for (int i = 0; i < _mat.length; i++) {
            for (int j = 0; j < _mat[0].length; j++) {
                if (_mat[i][j] == 1 && isSpecial(_mat, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSpecial(int[][] _mat, int _row, int _col) {
        for (int i = 0; i < _mat.length; i++) {
            if (i != _row && _mat[i][_col] == 1) {
                return false;
            }
        }
        for (int j = 0; j < _mat[0].length; j++) {
            if (j != _col && _mat[_row][j] == 1) {
                return false;
            }
        }
        return true;
    }

}
