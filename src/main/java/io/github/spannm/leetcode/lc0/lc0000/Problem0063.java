package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/unique-paths-ii/">63. Unique Paths II</a>.
 */
class Problem0063 extends LeetcodeProblem {

    int uniquePathsWithObstacles(int[][] _grid) {
        if (_grid[0][0] == 1) {
            return 0;
        }

        final int rows = _grid.length;
        final int cols = _grid[0].length;

        int[][] dp = new int[rows][cols];
        for (int c = 0; c < cols && _grid[0][c] == 0; c++) {
            dp[0][c] = 1;
        }
        for (int r = 0; r < rows && _grid[r][0] == 0; r++) {
            dp[r][0] = 1;
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (_grid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }
        int result = dp[rows - 1][cols - 1];

        _grid = null;
        dp = null;
        System.gc();

        return result;
    }

}
