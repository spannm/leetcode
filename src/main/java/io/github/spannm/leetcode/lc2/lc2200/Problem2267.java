package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2267. Check if There Is a Valid Parentheses String Path.
 */
class Problem2267 extends LeetcodeProblem {

    private char[][]      grid;
    private int           nbRows;
    private int           nbCols;
    private boolean[][][] vis;

    boolean hasValidPath(char[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        vis = new boolean[nbRows][nbCols][nbRows + nbCols];
        return dfs(0, 0, 0);
    }

    boolean dfs(int i, int j, int t) {
        if (vis[i][j][t]) {
            return false;
        }
        vis[i][j][t] = true;
        t += grid[i][j] == '(' ? 1 : -1;
        if (t < 0) {
            return false;
        }
        if (i == nbRows - 1 && j == nbCols - 1) {
            return t == 0;
        }
        int[] dirs = {0, 1, 0};
        for (int k = 0; k < 2; k++) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (x < nbRows && y < nbCols && dfs(x, y, t)) {
                return true;
            }
        }
        return false;
    }

}
