package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1391. Check if There is a Valid Path in a Grid.
 */
class Problem1391 extends LeetcodeProblem {

    private int[][] grid;
    private int     nbRows;
    private int     nbCols;
    private int[]   p;

    boolean hasValidPath(int[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        p = new int[nbRows * nbCols];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                int e = _grid[r][c];
                if (e == 1) {
                    left(r, c);
                    right(r, c);
                } else if (e == 2) {
                    up(r, c);
                    down(r, c);
                } else if (e == 3) {
                    left(r, c);
                    down(r, c);
                } else if (e == 4) {
                    right(r, c);
                    down(r, c);
                } else if (e == 5) {
                    left(r, c);
                    up(r, c);
                } else {
                    right(r, c);
                    up(r, c);
                }
            }
        }
        return find(0) == find(nbRows * nbCols - 1);
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void left(int _r, int _c) {
        if (_c > 0 && (grid[_r][_c - 1] == 1 || grid[_r][_c - 1] == 4 || grid[_r][_c - 1] == 6)) {
            p[find(_r * nbCols + _c)] = find(_r * nbCols + _c - 1);
        }
    }

    private void right(int _r, int _c) {
        if (_c < nbCols - 1 && (grid[_r][_c + 1] == 1 || grid[_r][_c + 1] == 3 || grid[_r][_c + 1] == 5)) {
            p[find(_r * nbCols + _c)] = find(_r * nbCols + _c + 1);
        }
    }

    private void up(int _r, int _c) {
        if (_r > 0 && (grid[_r - 1][_c] == 2 || grid[_r - 1][_c] == 3 || grid[_r - 1][_c] == 4)) {
            p[find(_r * nbCols + _c)] = find((_r - 1) * nbCols + _c);
        }
    }

    private void down(int _r, int _c) {
        if (_r < nbRows - 1 && (grid[_r + 1][_c] == 2 || grid[_r + 1][_c] == 5 || grid[_r + 1][_c] == 6)) {
            p[find(_r * nbCols + _c)] = find((_r + 1) * nbCols + _c);
        }
    }

}
