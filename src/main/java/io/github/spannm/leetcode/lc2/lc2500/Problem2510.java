package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2510. Check if There is a Path With Equal Number of 0's And 1's.
 */
class Problem2510 extends LeetcodeProblem {

    private int[][]       grid;
    private int           nbRows;
    private int           nbCols;
    private int           s;
    private Boolean[][][] f;

    boolean isThereAPath(int[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        s = nbRows + nbCols - 1;
        f = new Boolean[nbRows][nbCols][s];
        if (s % 2 == 1) {
            return false;
        }
        s >>= 1;
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int k) {
        if (i >= nbRows || j >= nbCols) {
            return false;
        }
        k += grid[i][j];
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        if (k > s || i + j + 1 - k > s) {
            return false;
        }
        if (i == nbRows - 1 && j == nbCols - 1) {
            return k == s;
        }
        f[i][j][k] = dfs(i + 1, j, k) || dfs(i, j + 1, k);
        return f[i][j][k];
    }

}
