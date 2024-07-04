package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1730. Shortest Path to Get Food.
 */
class Problem1730 extends LeetcodeProblem {

    private static final int[] DIRS = {-1, 0, 1, 0, -1};

    int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0, x = 1; i < m && x == 1; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    q.offer(new int[] {i, j});
                    x = 0;
                    break;
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            for (int t = q.size(); t > 0; t--) {
                var p = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = p[0] + DIRS[k];
                    int y = p[1] + DIRS[k + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (grid[x][y] == '#') {
                            return ans;
                        }
                        if (grid[x][y] == 'O') {
                            grid[x][y] = 'X';
                            q.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
        return -1;
    }

}
