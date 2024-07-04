package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance.
 */
class Problem1334 extends LeetcodeProblem {

    int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final int inf = 1 << 29;
        int[][] g = new int[n][n];
        for (var e : g) {
            Arrays.fill(e, inf);
        }
        for (var e : edges) {
            int f = e[0];
            int t = e[1];
            int w = e[2];
            g[f][t] = w;
            g[t][f] = w;
        }
        for (int k = 0; k < n; k++) {
            g[k][k] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int ans = n;
        int cnt = inf;
        for (int i = n - 1; i >= 0; i--) {
            int t = 0;
            for (int d : g[i]) {
                if (d <= distanceThreshold) {
                    t++;
                }
            }
            if (t < cnt) {
                cnt = t;
                ans = i;
            }
        }
        return ans;
    }

}
