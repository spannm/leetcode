package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2664. The Knight’s Tour.
 */
class Problem2664 extends LeetcodeProblem {

    private int     m;
    private int     n;
    private int[][] g;
    private boolean ok;

    int[][] tourOfKnight(int _m, int _n, int _r, int _c) {
        m = _m;
        n = _n;
        g = new int[_m][_n];
        for (var row : g) {
            Arrays.fill(row, -1);
        }
        g[_r][_c] = 0;
        dfs(_r, _c);
        return g;
    }

    private void dfs(int i, int j) {
        if (g[i][j] == m * n - 1) {
            ok = true;
            return;
        }
        int[] dirs = {-2, -1, 2, 1, -2, 1, 2, -1, -2};
        for (int k = 0; k < 8; k++) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && g[x][y] == -1) {
                g[x][y] = g[i][j] + 1;
                dfs(x, y);
                if (ok) {
                    return;
                }
                g[x][y] = -1;
            }
        }
    }

}
