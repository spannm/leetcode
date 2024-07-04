package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2304. Minimum Path Cost in a Grid.
 */
class Problem2304 extends LeetcodeProblem {

    int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[] f = grid[0];
        final int inf = 1 << 30;
        for (int i = 1; i < m; i++) {
            int[] g = new int[n];
            Arrays.fill(g, inf);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    g[j] = Math.min(g[j], f[k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
            }
            f = g;
        }

        // return Arrays.stream(f).min().getAsInt();
        int ans = inf;
        for (int v : f) {
            ans = Math.min(ans, v);
        }
        return ans;
    }

}
