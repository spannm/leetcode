package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2319 extends LeetcodeProblem {

    boolean checkXMatrix(int[][] _grid) {
        int m = _grid.length;
        boolean[][] checked = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            if (_grid[i][i] == 0) {
                return false;
            } else {
                checked[i][i] = true;
            }
        }
        for (int i = 0, j = m - 1; i < m && j >= 0; i++, j--) {
            if (_grid[i][j] == 0) {
                return false;
            } else {
                checked[i][j] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (!checked[i][j] && _grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
