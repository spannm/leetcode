package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 909. Snakes and Ladders.
 */
class Problem0909 extends LeetcodeProblem {

    private int n;

    int snakesAndLadders(int[][] _board) {
        n = _board.length;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        boolean[] vis = new boolean[n * n + 1];
        vis[1] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            for (int t = q.size(); t > 0; t--) {
                int curr = q.poll();
                if (curr == n * n) {
                    return ans;
                }
                for (int k = curr + 1; k <= Math.min(curr + 6, n * n); k++) {
                    int[] p = get(k);
                    int next = k;
                    int i = p[0];
                    int j = p[1];
                    if (_board[i][j] != -1) {
                        next = _board[i][j];
                    }
                    if (!vis[next]) {
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private int[] get(int _x) {
        int i = (_x - 1) / n;
        int j = (_x - 1) % n;
        if (i % 2 == 1) {
            j = n - 1 - j;
        }
        return new int[] {n - 1 - i, j};
    }

}
