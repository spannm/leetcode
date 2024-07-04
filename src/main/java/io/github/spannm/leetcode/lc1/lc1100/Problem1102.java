package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1102. Path With Maximum Minimum Value.
 */
class Problem1102 extends LeetcodeProblem {

    int maximumMinimumPath(int[][] _grid) {
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        int[] p = new int[nbRows * nbCols];
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                q.add(new int[] {_grid[i][j], i, j});
                p[i * nbCols + j] = i * nbCols + j;
            }
        }
        q.sort((a, b) -> b[0] - a[0]);
        boolean[][] vis = new boolean[nbRows][nbCols];
        int[] dirs = {-1, 0, 1, 0, -1};
        int ans = 0;
        for (int i = 0; find(0, p) != find(nbRows * nbCols - 1, p); i++) {
            int[] t = q.get(i);
            vis[t[1]][t[2]] = true;
            ans = t[0];
            for (int k = 0; k < 4; k++) {
                int x = t[1] + dirs[k];
                int y = t[2] + dirs[k + 1];
                if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && vis[x][y]) {
                    p[find(x * nbCols + y, p)] = find(t[1] * nbCols + t[2], p);
                }
            }
        }
        return ans;
    }

    static int find(int _x, int[] _p) {
        if (_p[_x] != _x) {
            _p[_x] = find(_p[_x], _p);
        }
        return _p[_x];
    }

}
