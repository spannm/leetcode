package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2585. Number of Ways to Earn Points.
 */
class Problem2585 extends LeetcodeProblem {

    int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int count = types[i - 1][0];
            int marks = types[i - 1][1];
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= count; k++) {
                    if (j >= k * marks) {
                        f[i][j] = (f[i][j] + f[i - 1][j - k * marks]) % mod;
                    }
                }
            }
        }
        return f[n][target];
    }

}
