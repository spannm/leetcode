package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/number-of-closed-islands/">1254. Number of Closed Islands</a>.
 */
class Problem1254 extends LeetcodeProblem {

    int closedIsland(int[][] _map) {
        final int v = _map.length;
        final int h = _map[0].length;

        for (int row = 0; row < v; row++) {
            dfs(row, 0, _map);
            dfs(row, h - 1, _map);
        }
        for (int col = 0; col < h; col++) {
            dfs(0, col, _map);
            dfs(v - 1, col, _map);
        }
        int count = 0;
        for (int i = 1; i < v - 1; i++) {
            for (int j = 1; j < h - 1; j++) {
                if (_map[i][j] == 0) {
                    dfs(i, j, _map);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int _i, int _j, int[][] _grid) {
        int m = _grid.length;
        int n = _grid[0].length;
        if (_i < 0 || _i >= m || _j < 0 || _j >= n || _grid[_i][_j] != 0) {
            return;
        }

        _grid[_i][_j] = 1;
        dfs(_i + 1, _j, _grid);
        dfs(_i - 1, _j, _grid);
        dfs(_i, _j + 1, _grid);
        dfs(_i, _j - 1, _grid);
    }

}
