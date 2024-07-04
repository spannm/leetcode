package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1883. Minimum Skips to Arrive at Meeting On Time.
 */
class Problem1883 extends LeetcodeProblem {

    int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        double[][] f = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], 1e20);
        }
        f[0][0] = 0;
        double eps = 1e-8;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < i) {
                    f[i][j] = Math.min(
                        f[i][j], Math.ceil(f[i - 1][j]) + 1.0 * dist[i - 1] / speed - eps);
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1.0 * dist[i - 1] / speed);
                }
            }
        }
        for (int j = 0; j <= n; j++) {
            if (f[n][j] <= hoursBefore + eps) {
                return j;
            }
        }
        return -1;
    }

}
