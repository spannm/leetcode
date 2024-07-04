package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/">2328. Number of Increasing Paths in a
 * Grid</a>.
 */
class Problem2328 extends LeetcodeProblem {

    static final int MOD = (int) Math.pow(10, 9) + 7;

    static int countPaths(final int[][] _grid) {
        final int rowCount = _grid.length;
        final int colCount = _grid[0].length;

        int[][] dp = new int[rowCount][colCount];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (dp[r][c] == -1) {
                    calc(r, c, _grid, dp, -1);
                }
            }
        }

        long pathSum = 0;
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                pathSum = (pathSum + dp[r][c]) % MOD;
            }
        }
        return (int) pathSum;
    }

    static int calc(int _row, int _col, int[][] _grid, int[][] _dp, int _parent) {
        if (_row < 0 || _col < 0) {
            return 0;
        }

        final int rowCount = _grid.length;
        final int colCount = _grid[0].length;

        if (_row >= rowCount || _col >= colCount || _grid[_row][_col] <= _parent) {
            return 0;
        } else if (_dp[_row][_col] != -1) {
            return _dp[_row][_col];
        }

        final int down = calc(_row + 1, _col, _grid, _dp, _grid[_row][_col]) % MOD;
        final int up = calc(_row - 1, _col, _grid, _dp, _grid[_row][_col]) % MOD;
        final int right = calc(_row, _col + 1, _grid, _dp, _grid[_row][_col]) % MOD;
        final int left = calc(_row, _col - 1, _grid, _dp, _grid[_row][_col]) % MOD;

        return _dp[_row][_col] = (down + up + right + left + 1) % MOD;
    }

}
