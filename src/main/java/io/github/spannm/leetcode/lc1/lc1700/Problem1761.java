package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1761. Minimum Degree of a Connected Trio in a Graph.
 */
class Problem1761 extends LeetcodeProblem {

    int minTrioDegree(int n, int[][] edges) {
        boolean[][] g = new boolean[n][n];
        int[] deg = new int[n];
        for (var e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            g[u][v] = true;
            g[v][u] = true;
            deg[u]++;
            deg[v]++;
        }
        int ans = 1 << 30;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (g[i][j]) {
                    for (int k = j + 1; k < n; k++) {
                        if (g[i][k] && g[j][k]) {
                            ans = Math.min(ans, deg[i] + deg[j] + deg[k] - 6);
                        }
                    }
                }
            }
        }
        return ans == 1 << 30 ? -1 : ans;
    }

}
