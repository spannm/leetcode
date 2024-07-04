package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2658. Maximum Number of Fish in a Grid.
 */
class Problem2658 extends LeetcodeProblem {

    private int[][] grid;
    private int     nbRows;
    private int     nbCols;

    int findMaxFish(int[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        int ans = 0;
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_grid[r][c] > 0) {
                    ans = Math.max(ans, dfs(r, c));
                }
            }
        }
        return ans;
    }

    private int dfs(int _r, int _c) {
        int cnt = grid[_r][_c];
        grid[_r][_c] = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = _r + dirs[k];
            int y = _c + dirs[k + 1];
            if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && grid[x][y] > 0) {
                cnt += dfs(x, y);
            }
        }
        return cnt;
    }

}
