package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1706. Where Will the Ball Fall.
 */
class Problem1706 extends LeetcodeProblem {

    private int[][] grid;
    private int     nbRows;
    private int     nbCols;

    int[] findBall(int[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        int[] ans = new int[nbCols];
        for (int c = 0; c < nbCols; c++) {
            ans[c] = dfs(0, c);
        }
        return ans;
    }

    private int dfs(int _r, int _c) {
        if (_r == nbRows) {
            return _c;
        } else if (_c == 0 && grid[_r][_c] == -1 || _c == nbCols - 1 && grid[_r][_c] == 1) {
            return -1;
        } else if (grid[_r][_c] == 1 && grid[_r][_c + 1] == -1) {
            return -1;
        } else if (grid[_r][_c] == -1 && grid[_r][_c - 1] == 1) {
            return -1;
        }
        return grid[_r][_c] == 1 ? dfs(_r + 1, _c + 1) : dfs(_r + 1, _c - 1);
    }

}
