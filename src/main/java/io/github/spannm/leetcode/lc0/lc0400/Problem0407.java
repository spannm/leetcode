package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 407. Trapping Rain Water II.
 */
class Problem0407 extends LeetcodeProblem {

    int trapRainWater(int[][] _heightMap) {
        int m = _heightMap.length;
        int n = _heightMap[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[] {_heightMap[i][j], i, j});
                    vis[i][j] = true;
                }
            }
        }
        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            for (int k = 0; k < 4; k++) {
                int x = p[1] + dirs[k];
                int y = p[2] + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                    ans += Math.max(0, p[0] - _heightMap[x][y]);
                    vis[x][y] = true;
                    pq.offer(new int[] {Math.max(p[0], _heightMap[x][y]), x, y});
                }
            }
        }
        return ans;
    }

}
