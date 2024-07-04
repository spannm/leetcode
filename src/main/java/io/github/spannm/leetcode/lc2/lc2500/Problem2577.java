package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2577. Minimum Time to Visit a Cell In a Grid.
 */
class Problem2577 extends LeetcodeProblem {

    int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (var e : dist) {
            Arrays.fill(e, 1 << 30);
        }
        dist[0][0] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, 0, 0});
        int[] dirs = {-1, 0, 1, 0, -1};
        while (true) {
            var p = pq.poll();
            int i = p[1];
            int j = p[2];
            if (i == m - 1 && j == n - 1) {
                return p[0];
            }
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int nt = p[0] + 1;
                    if (nt < grid[x][y]) {
                        nt = grid[x][y] + (grid[x][y] - nt) % 2;
                    }
                    if (nt < dist[x][y]) {
                        dist[x][y] = nt;
                        pq.offer(new int[] {nt, x, y});
                    }
                }
            }
        }
    }

}
