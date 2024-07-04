package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1293. Shortest Path in a Grid with Obstacles Elimination.
 */
class Problem1293 extends LeetcodeProblem {

    int shortestPath(int[][] _grid, int _k) {
        int m = _grid.length;
        int n = _grid[0].length;
        if (_k >= m + n - 3) {
            return m + n - 2;
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, _k});
        boolean[][][] vis = new boolean[m][n][_k + 1];
        vis[0][0][_k] = true;
        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            ans++;
            for (int i = q.size(); i > 0; i--) {
                int[] p = q.poll();
                _k = p[2];
                for (int j = 0; j < 4; j++) {
                    int x = p[0] + dirs[j];
                    int y = p[1] + dirs[j + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (x == m - 1 && y == n - 1) {
                            return ans;
                        }
                        if (_grid[x][y] == 0 && !vis[x][y][_k]) {
                            q.offer(new int[] {x, y, _k});
                            vis[x][y][_k] = true;
                        } else if (_grid[x][y] == 1 && _k > 0 && !vis[x][y][_k - 1]) {
                            q.offer(new int[] {x, y, _k - 1});
                            vis[x][y][_k - 1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
