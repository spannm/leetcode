package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2503. Maximum Number of Points From Grid Queries.
 */
class Problem2503 extends LeetcodeProblem {

    int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;
        int[][] qs = new int[k][2];
        for (int i = 0; i < k; i++) {
            qs[i] = new int[] {queries[i], i};
        }
        Arrays.sort(qs, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[k];
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[] {grid[0][0], 0, 0});
        int[] dirs = new int[] {-1, 0, 1, 0, -1};
        int cnt = 0;
        for (var e : qs) {
            int v = e[0];
            k = e[1];
            while (!q.isEmpty() && q.peek()[0] < v) {
                var p = q.poll();
                cnt++;
                for (int h = 0; h < 4; h++) {
                    int x = p[1] + dirs[h];
                    int y = p[2] + dirs[h + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                        vis[x][y] = true;
                        q.offer(new int[] {grid[x][y], x, y});
                    }
                }
            }
            ans[k] = cnt;
        }
        return ans;
    }

}
