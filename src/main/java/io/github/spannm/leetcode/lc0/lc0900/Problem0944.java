package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>.
 */
class Problem0944 extends LeetcodeProblem {

    int orangesRotting(int[][] _grid) {
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        int minutes = 0;
        int fresh0 = 0;
        int fresh = 0;

        for (int[] ints : _grid) {
            for (int col = 0; col < nbCols; col++) {
                if (ints[col] == 1) {
                    fresh++;
                }
            }
        }

        while (fresh > 0) {
            fresh0 = fresh;
            for (int row = 0; row < nbRows; row++) {
                for (int col = 0; col < nbCols; col++) {
                    if (_grid[row][col] == 2) {
                        if (row + 1 < nbRows && _grid[row + 1][col] == 1) {
                            _grid[row + 1][col] = 3;
                            fresh--;
                        }
                        if (row - 1 >= 0 && _grid[row - 1][col] == 1) {
                            _grid[row - 1][col] = 3;
                            fresh--;
                        }
                        if (col - 1 >= 0 && _grid[row][col - 1] == 1) {
                            _grid[row][col - 1] = 3;
                            fresh--;
                        }
                        if (col + 1 < nbCols && _grid[row][col + 1] == 1) {
                            _grid[row][col + 1] = 3;
                            fresh--;
                        }
                    }
                }
            }
            for (int row = 0; row < nbRows; row++) {
                for (int col = 0; col < nbCols; col++) {
                    if (_grid[row][col] == 3) {
                        _grid[row][col] = 2;
                    }
                }
            }
            if (fresh0 == fresh) {
                return -1;
            }
            minutes++;
        }
        return minutes;
    }

}
