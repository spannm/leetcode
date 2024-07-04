package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1210. Minimum Moves to Reach Target with Rotations.
 */
class Problem1210 extends LeetcodeProblem {

    private int                n;
    private int[][]            grid;
    private boolean[][]        vis;
    private final Deque<int[]> q = new ArrayDeque<>();

    int minimumMoves(int[][] _grid) {
        grid = _grid;
        n = _grid.length;
        vis = new boolean[n * n][2];
        int[] target = {n * n - 2, n * n - 1};
        q.offer(new int[] {0, 1});
        vis[0][0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                var p = q.poll();
                if (p[0] == target[0] && p[1] == target[1]) {
                    return ans;
                }
                int i1 = p[0] / n;
                int j1 = p[0] % n;
                int i2 = p[1] / n;
                int j2 = p[1] % n;
                move(i1, j1 + 1, i2, j2 + 1);
                move(i1 + 1, j1, i2 + 1, j2);
                if (i1 == i2 && i1 + 1 < n && _grid[i1 + 1][j2] == 0) {
                    move(i1, j1, i1 + 1, j1);
                }
                if (j1 == j2 && j1 + 1 < n && _grid[i2][j1 + 1] == 0) {
                    move(i1, j1, i1, j1 + 1);
                }
            }
            ans++;
        }
        return -1;
    }

    void move(int _i1, int _j1, int _i2, int _j2) {
        if (_i1 >= 0 && _i1 < n && _j1 >= 0 && _j1 < n && _i2 >= 0 && _i2 < n && _j2 >= 0 && _j2 < n) {
            int a = _i1 * n + _j1;
            int b = _i2 * n + _j2;
            int status = _i1 == _i2 ? 0 : 1;
            if (!vis[a][status] && grid[_i1][_j1] == 0 && grid[_i2][_j2] == 0) {
                q.offer(new int[] {a, b});
                vis[a][status] = true;
            }
        }
    }

}
