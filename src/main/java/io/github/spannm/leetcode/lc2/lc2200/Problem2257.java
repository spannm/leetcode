package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2257. Count Unguarded Cells in the Grid.
 */
class Problem2257 extends LeetcodeProblem {

    int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] g = new int[m][n];
        for (var e : guards) {
            g[e[0]][e[1]] = 2;
        }
        for (var e : walls) {
            g[e[0]][e[1]] = 2;
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        for (var e : guards) {
            for (int k = 0; k < 4; k++) {
                int x = e[0];
                int y = e[1];
                int a = dirs[k];
                int b = dirs[k + 1];
                while (x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && g[x + a][y + b] < 2) {
                    x += a;
                    y += b;
                    g[x][y] = 1;
                }
            }
        }
        int ans = 0;
        for (var row : g) {
            for (int v : row) {
                if (v == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
