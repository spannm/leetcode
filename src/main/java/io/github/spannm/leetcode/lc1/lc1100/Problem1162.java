package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1162. As Far from Land as Possible.
 */
class Problem1162 extends LeetcodeProblem {

    int maxDistance(int[][] _grid) {
        int n = _grid.length;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (_grid[i][j] == 1) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int ans = -1;
        if (q.isEmpty() || q.size() == n * n) {
            return ans;
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] p = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = p[0] + dirs[k];
                    int y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < n && y >= 0 && y < n && _grid[x][y] == 0) {
                        _grid[x][y] = 1;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            ans++;
        }
        return ans;
    }

}
