package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2735. Collecting Chocolates.
 */
class Problem2735 extends LeetcodeProblem {

    long minCost(int[] nums, int x) {
        int n = nums.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][0] = nums[i];
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i][j - 1], nums[(i + j) % n]);
            }
        }
        long ans = 1L << 60;
        for (int j = 0; j < n; j++) {
            long cost = 1L * j * x;
            for (int i = 0; i < n; i++) {
                cost += f[i][j];
            }
            ans = Math.min(ans, cost);
        }
        return ans;
    }

}
