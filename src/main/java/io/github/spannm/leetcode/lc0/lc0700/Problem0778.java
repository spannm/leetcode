package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 778. Swim in Rising Water.
 */
class Problem0778 extends LeetcodeProblem {

    int swimInWater(int[][] _grid) {
        int nbRows = _grid.length;
        int[] p = new int[nbRows * nbRows];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        int[] hi = new int[nbRows * nbRows];
        for (int r1 = 0; r1 < nbRows; r1++) {
            for (int r2 = 0; r2 < nbRows; r2++) {
                hi[_grid[r1][r2]] = r1 * nbRows + r2;
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int t = 0; t < nbRows * nbRows; t++) {
            int i = hi[t] / nbRows;
            int j = hi[t] % nbRows;
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < nbRows && y >= 0 && y < nbRows && _grid[x][y] <= t) {
                    p[find(x * nbRows + y, p)] = find(i * nbRows + j, p);
                }
                if (find(0, p) == find(nbRows * nbRows - 1, p)) {
                    return t;
                }
            }
        }
        return -1;
    }

    static int find(int _x, int[] _p) {
        if (_p[_x] != _x) {
            _p[_x] = find(_p[_x], _p);
        }
        return _p[_x];
    }

}
