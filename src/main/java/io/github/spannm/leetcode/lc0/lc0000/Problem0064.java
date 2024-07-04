package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum/">64. Minimum Path Sum</a>.
 */
class Problem0064 extends LeetcodeProblem {

    int minPathSum(final int[][] _grid) {
        final int rowCount = _grid.length;
        final int colCount = _grid[0].length;

        for (int row = 1; row < rowCount; row++) {
            _grid[row][0] += _grid[row - 1][0];
        }

        for (int col = 1; col < colCount; col++) {
            _grid[0][col] += _grid[0][col - 1];
        }

        for (int row = 1; row < rowCount; row++) {
            for (int col = 1; col < colCount; col++) {
                _grid[row][col] += Math.min(_grid[row - 1][col], _grid[row][col - 1]);
            }
        }

        return _grid[rowCount - 1][colCount - 1];
    }

}
