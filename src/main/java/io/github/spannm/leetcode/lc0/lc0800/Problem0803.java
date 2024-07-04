package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 803. Bricks Falling When Hit.
 */
class Problem0803 extends LeetcodeProblem {

    private int[] p;
    private int[] size;

    int[] hitBricks(int[][] _grid, int[][] _hits) {
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        p = new int[nbRows * nbCols + 1];
        size = new int[nbRows * nbCols + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            size[i] = 1;
        }
        int[][] g = new int[nbRows][nbCols];
        for (int i = 0; i < nbRows; i++) {
            System.arraycopy(_grid[i], 0, g[i], 0, nbCols);
        }
        for (int[] h : _hits) {
            g[h[0]][h[1]] = 0;
        }
        for (int j = 0; j < nbCols; j++) {
            if (g[0][j] == 1) {
                union(j, nbRows * nbCols);
            }
        }
        for (int i = 1; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (g[i][j] == 0) {
                    continue;
                }
                if (g[i - 1][j] == 1) {
                    union(i * nbCols + j, (i - 1) * nbCols + j);
                }
                if (j > 0 && g[i][j - 1] == 1) {
                    union(i * nbCols + j, i * nbCols + j - 1);
                }
            }
        }
        int[] ans = new int[_hits.length];
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = _hits.length - 1; k >= 0; k--) {
            int i = _hits[k][0];
            int j = _hits[k][1];
            if (_grid[i][j] == 0) {
                continue;
            }
            g[i][j] = 1;
            int prev = size[find(nbRows * nbCols)];
            if (i == 0) {
                union(j, nbRows * nbCols);
            }
            for (int l = 0; l < 4; l++) {
                int x = i + dirs[l];
                int y = j + dirs[l + 1];
                if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && g[x][y] == 1) {
                    union(i * nbCols + j, x * nbCols + y);
                }
            }
            int curr = size[find(nbRows * nbCols)];
            ans[k] = Math.max(0, curr - prev - 1);
        }
        return ans;
    }

    private int find(int _x) {
        if (p[_x] != _x) {
            p[_x] = find(p[_x]);
        }
        return p[_x];
    }

    private void union(int _a, int _b) {
        int pa = find(_a);
        int pb = find(_b);
        if (pa != pb) {
            size[pb] += size[pa];
            p[pa] = pb;
        }
    }

}
