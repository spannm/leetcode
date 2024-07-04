package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1568. Minimum Number of Days to Disconnect Island.
 */
class Problem1568 extends LeetcodeProblem {

    private static final int[] DIRS = new int[] {-1, 0, 1, 0, -1};

    private int[][]            grid;
    private int                nbRows;
    private int                nbCols;

    int minDays(int[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        if (count() != 1) {
            return 0;
        }
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (_grid[i][j] == 1) {
                    _grid[i][j] = 0;
                    if (count() != 1) {
                        return 1;
                    }
                    _grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private int count() {
        int cnt = 0;
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (grid[r][c] == 1) {
                    dfs(r, c);
                    cnt++;
                }
            }
        }
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (grid[r][c] == 2) {
                    grid[r][c] = 1;
                }
            }
        }
        return cnt;
    }

    private void dfs(int _r, int _c) {
        grid[_r][_c] = 2;
        for (int k = 0; k < 4; k++) {
            int x = _r + DIRS[k];
            int y = _c + DIRS[k + 1];
            if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && grid[x][y] == 1) {
                dfs(x, y);
            }
        }
    }

}
