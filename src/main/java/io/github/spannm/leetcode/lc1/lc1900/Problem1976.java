package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1976. Number of Ways to Arrive at Destination.
 */
class Problem1976 extends LeetcodeProblem {

    private static final long INF = Long.MAX_VALUE / 2;
    private static final int  MOD = (int) 1e9 + 7;

    int countPaths(int n, int[][] roads) {
        final long[][] g = new long[n][n];
        final long[] dist = new long[n];
        final long[] w = new long[n];
        final boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
            Arrays.fill(dist, INF);
        }
        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int t = r[2];
            g[u][v] = t;
            g[v][u] = t;
        }
        g[0][0] = 0;
        dist[0] = 0;
        w[0] = 1;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 0; j < n; j++) {
                if (j == t) {
                    continue;
                }
                long ne = dist[t] + g[t][j];
                if (dist[j] > ne) {
                    dist[j] = ne;
                    w[j] = w[t];
                } else if (dist[j] == ne) {
                    w[j] = (w[j] + w[t]) % MOD;
                }
            }
        }
        return (int) w[n - 1];
    }

}
