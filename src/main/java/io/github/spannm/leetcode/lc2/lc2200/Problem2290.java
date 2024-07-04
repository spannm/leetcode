package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2290. Minimum Obstacle Removal to Reach Corner.
 */
class Problem2290 extends LeetcodeProblem {

    int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});
        int[] dirs = {-1, 0, 1, 0, -1};
        boolean[][] vis = new boolean[m][n];
        while (true) {
            var p = q.poll();
            int i = p[0];
            int j = p[1];
            int k = p[2];
            if (i == m - 1 && j == n - 1) {
                return k;
            }
            if (vis[i][j]) {
                continue;
            }
            vis[i][j] = true;
            for (int h = 0; h < 4; h++) {
                int x = i + dirs[h];
                int y = j + dirs[h + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == 0) {
                        q.offerFirst(new int[] {x, y, k});
                    } else {
                        q.offerLast(new int[] {x, y, k + 1});
                    }
                }
            }
        }
    }

}
