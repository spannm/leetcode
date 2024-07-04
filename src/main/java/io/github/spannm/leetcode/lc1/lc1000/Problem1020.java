package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/number-of-enclaves/">1020. Number of Enclaves</a>.
 */
class Problem1020 extends LeetcodeProblem {

    int numEnclaves(final int[][] _grid) {
        final int rowCount = _grid.length;
        final int colCount = _grid[0].length;

        // mark all boundary land cells and their connected cells
        for (int row = 0; row < rowCount; row++) {
            dfs(row, 0, _grid, rowCount, colCount);
            dfs(row, colCount - 1, _grid, rowCount, colCount);
        }
        for (int col = 0; col < colCount; col++) {
            dfs(0, col, _grid, rowCount, colCount);
            dfs(rowCount - 1, col, _grid, rowCount, colCount);
        }

        // count unmarked land cells
        int count = 0;
        for (int[] ints : _grid) {
            for (int j = 0; j < colCount; j++) {
                if (ints[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int _row, int _col, final int[][] _grid, int _rowCount, int _colCount) {
        if (_row < 0 || _row >= _rowCount || _col < 0 || _col >= _colCount || _grid[_row][_col] != 1) {
            return;
        }
        _grid[_row][_col] = -1; // mark as visited
        dfs(_row + 1, _col, _grid, _rowCount, _colCount);
        dfs(_row - 1, _col, _grid, _rowCount, _colCount);
        dfs(_row, _col + 1, _grid, _rowCount, _colCount);
        dfs(_row, _col - 1, _grid, _rowCount, _colCount);
    }

}
