package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 2174. Remove All Ones With Row and Column Flips II.
 */
class Problem2174 extends LeetcodeProblem {

    int removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int state = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    state |= 1 << i * n + j;
                }
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(state);
        Set<Integer> vis = new HashSet<>();
        vis.add(state);
        int ans = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                state = q.poll();
                if (state == 0) {
                    return ans;
                }
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == 0) {
                            continue;
                        }
                        int nxt = state;
                        for (int r = 0; r < m; r++) {
                            nxt &= ~(1 << r * n + j);
                        }
                        for (int c = 0; c < n; c++) {
                            nxt &= ~(1 << i * n + c);
                        }
                        if (!vis.contains(nxt)) {
                            vis.add(nxt);
                            q.offer(nxt);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}
