package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1034. Coloring A Border.
 */
class Problem1034 extends LeetcodeProblem {

    private int[][]     grid;
    private int         color;
    private int         m;
    private int         n;
    private boolean[][] vis;

    int[][] colorBorder(int[][] _grid, int _row, int _col, int _color) {
        grid = _grid;
        color = _color;
        m = _grid.length;
        n = _grid[0].length;
        vis = new boolean[m][n];
        dfs(_row, _col, _grid[_row][_col]);
        return _grid;
    }

    private void dfs(int _i, int _j, int _c) {
        vis[_i][_j] = true;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = _i + dirs[k];
            int y = _j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (!vis[x][y]) {
                    if (grid[x][y] == _c) {
                        dfs(x, y, _c);
                    } else {
                        grid[_i][_j] = color;
                    }
                }
            } else {
                grid[_i][_j] = color;
            }
        }
    }

}
