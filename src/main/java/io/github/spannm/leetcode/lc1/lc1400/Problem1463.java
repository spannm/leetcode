package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1463. Cherry Pickup II.
 */
class Problem1463 extends LeetcodeProblem {

    int cherryPickup(int[][] _grid) {
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        int[][] f = new int[nbCols][nbCols];
        int[][] g = new int[nbCols][nbCols];
        for (int i = 0; i < nbCols; i++) {
            Arrays.fill(f[i], -1);
            Arrays.fill(g[i], -1);
        }
        f[0][nbCols - 1] = _grid[0][0] + _grid[0][nbCols - 1];
        for (int r = 1; r < nbRows; r++) {
            for (int c1 = 0; c1 < nbCols; c1++) {
                for (int c2 = 0; c2 < nbCols; c2++) {
                    int x = _grid[r][c1] + (c1 == c2 ? 0 : _grid[r][c2]);
                    for (int c3 = c1 - 1; c3 <= c1 + 1; c3++) {
                        for (int y2 = c2 - 1; y2 <= c2 + 1; y2++) {
                            if (c3 >= 0 && c3 < nbCols && y2 >= 0 && y2 < nbCols && f[c3][y2] != -1) {
                                g[c1][c2] = Math.max(g[c1][c2], f[c3][y2] + x);
                            }
                        }
                    }
                }
            }
            int[][] t = f;
            f = g;
            g = t;
        }
        int result = 0;
        for (int c1 = 0; c1 < nbCols; c1++) {
            for (int c2 = 0; c2 < nbCols; c2++) {
                result = Math.max(result, f[c1][c2]);
            }
        }
        return result;
    }

}
