package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * 2836. Maximize Value of Function in a Ball Passing Game.
 */
class Problem2836 extends LeetcodeProblem {

    long getMaxFunctionValue(List<Integer> receiver, long k) {
        int n = receiver.size();
        int m = 64 - Long.numberOfLeadingZeros(k);
        int[][] f = new int[n][m];
        long[][] g = new long[n][m];
        for (int i = 0; i < n; i++) {
            f[i][0] = receiver.get(i);
            g[i][0] = i;
        }
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                f[i][j] = f[f[i][j - 1]][j - 1];
                g[i][j] = g[i][j - 1] + g[f[i][j - 1]][j - 1];
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int p = i;
            long t = 0;
            for (int j = 0; j < m; j++) {
                if ((k >> j & 1) == 1) {
                    t += g[p][j];
                    p = f[p][j];
                }
            }
            ans = Math.max(ans, p + t);
        }
        return ans;
    }

}
