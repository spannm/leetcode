package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1905. Count Sub Islands.
 */
class Problem1905 extends LeetcodeProblem {

    private static final int[] DIRS = {-1, 0, 1, 0, -1};
    private int[][]            grid1;
    private int[][]            grid2;
    private int                nbRows;
    private int                nbCols;

    int countSubIslands(int[][] _grid1, int[][] _grid2) {
        nbRows = _grid1.length;
        nbCols = _grid1[0].length;
        grid1 = _grid1;
        grid2 = _grid2;
        int ans = 0;
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_grid2[r][c] == 1) {
                    ans += dfs(r, c);
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        int ok = grid1[i][j];
        grid2[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + DIRS[k];
            int y = j + DIRS[k + 1];
            if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && grid2[x][y] == 1) {
                ok &= dfs(x, y);
            }
        }
        return ok;
    }

}
