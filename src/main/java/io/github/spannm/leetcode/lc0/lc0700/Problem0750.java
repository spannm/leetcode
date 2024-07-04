package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0750 extends LeetcodeProblem {

    int countCornerRectangles(int[][] _grid) {
        if (_grid == null || _grid.length < 2) {
            return 0;
        }
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        int count = 0;
        for (int r = 0; r < nbRows - 1; r++) {
            for (int c = 0; c < nbCols - 1; c++) {
                if (_grid[r][c] == 1) {
                    for (int cnext = c + 1; cnext < nbCols; cnext++) {
                        if (_grid[r][cnext] == 1) {
                            for (int rnext = r + 1; rnext < nbRows; rnext++) {
                                if (_grid[rnext][c] == 1 && _grid[rnext][cnext] == 1) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
