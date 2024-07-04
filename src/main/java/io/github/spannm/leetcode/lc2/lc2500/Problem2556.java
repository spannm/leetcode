package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2556. Disconnect Path in a Binary Matrix by at Most One Flip.
 */
class Problem2556 extends LeetcodeProblem {

    private int[][] grid;
    private int     nbRows;
    private int     nbCols;

    boolean isPossibleToCutPath(int[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        boolean a = dfs(0, 0);
        _grid[0][0] = 1;
        _grid[nbRows - 1][nbCols - 1] = 1;
        boolean b = dfs(0, 0);
        return !(a && b);
    }

    private boolean dfs(int _r, int _c) {
        if (_r >= nbRows || _c >= nbCols || grid[_r][_c] == 0) {
            return false;
        } else if (_r == nbRows - 1 && _c == nbCols - 1) {
            return true;
        }
        grid[_r][_c] = 0;
        return dfs(_r + 1, _c) || dfs(_r, _c + 1);
    }

}
