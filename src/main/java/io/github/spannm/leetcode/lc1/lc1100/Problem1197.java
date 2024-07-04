package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1197. Minimum Knight Moves.
 */
class Problem1197 extends LeetcodeProblem {

    int minKnightMoves(int _x, int _y) {
        _x += 310;
        _y += 310;
        int ans = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {310, 310});
        boolean[][] vis = new boolean[700][700];
        vis[310][310] = true;
        int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                int[] p = q.poll();
                if (p[0] == _x && p[1] == _y) {
                    return ans;
                }
                for (int[] dir : dirs) {
                    int c = p[0] + dir[0];
                    int d = p[1] + dir[1];
                    if (!vis[c][d]) {
                        vis[c][d] = true;
                        q.offer(new int[] {c, d});
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}
