package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/compare-version-numbers/">200. Number of Islands</a>.
 */
class Problem0200 extends LeetcodeProblem {

    int numIslands(char[][] _grid) {
        if (_grid == null || _grid.length == 0) {
            return 0;
        }
        int count = 0;
        int rowCount = _grid.length;
        int colCount = _grid[0].length;
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (_grid[r][c] == '1') {
                    count++;
                    dfs(_grid, r, c, rowCount, colCount);
                }
            }
        }
        return count;
    }

    static void dfs(char[][] _grid, int _row, int _col, int _rowCount, int _colCount) {
        if (_row < 0 || _row >= _rowCount || _col < 0 || _col >= _colCount || _grid[_row][_col] == '0') {
            return;
        }
        _grid[_row][_col] = '0';
        dfs(_grid, _row + 1, _col, _rowCount, _colCount);
        dfs(_grid, _row, _col + 1, _rowCount, _colCount);
        dfs(_grid, _row - 1, _col, _rowCount, _colCount);
        dfs(_grid, _row, _col - 1, _rowCount, _colCount);
    }

}
