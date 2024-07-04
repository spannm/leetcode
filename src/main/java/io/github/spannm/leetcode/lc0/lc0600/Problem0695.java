package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/">695. Max Area of Island</a>.
 */
class Problem0695 extends LeetcodeProblem {

    int maxAreaOfIsland(int[][] _grid) {

        // find islands from top left
        final int nbRows = _grid.length;
        final int nbCols = _grid[0].length;

        boolean[][] seen = new boolean[nbRows][nbCols];
        int maxArea = 0;

        for (int row = 0; row < nbRows; row++) {
            for (int col = 0; col < nbCols; col++) {
                boolean isLand = _grid[row][col] == 1;

                if (isLand && !seen[row][col]) {
                    maxArea = Math.max(maxArea, calcIslandSize(row, col, _grid, nbRows, nbCols, seen));
                }

            }

        }

        return maxArea;
    }

    int calcIslandSize(int _row, int _col, final int[][] _grid, final int _nbRows, final int _nbCols, boolean[][] _seen) {
        if (_row < 0 || _row >= _nbRows) {
            return 0;
        } else if (_col < 0 || _col >= _nbCols) {
            return 0;
        } else if (_seen[_row][_col]) {
            return 0;
        } else if (_grid[_row][_col] == 0) { // water
            return 0;
        }

        _seen[_row][_col] = true;

        return 1
            + calcIslandSize(_row - 1, _col, _grid, _nbRows, _nbCols, _seen)
            + calcIslandSize(_row, _col + 1, _grid, _nbRows, _nbCols, _seen)
            + calcIslandSize(_row + 1, _col, _grid, _nbRows, _nbCols, _seen)
            + calcIslandSize(_row, _col - 1, _grid, _nbRows, _nbCols, _seen);
    }

}
