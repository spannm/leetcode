package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1959. Minimum Total Space Wasted With K Resizing Operations.
 */
class Problem1959 extends LeetcodeProblem {

    int minSpaceWastedKResizing(int[] nums, int k) {
        k++;
        int n = nums.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            int s = 0;
            int mx = 0;
            for (int j = i; j < n; j++) {
                s += nums[j];
                mx = Math.max(mx, nums[j]);
                g[i][j] = mx * (j - i + 1) - s;
            }
        }
        int[][] f = new int[n + 1][k + 1];
        int inf = 0x3f3f3f3f;
        for (int[] element : f) {
            Arrays.fill(element, inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int h = 0; h < i; h++) {
                    f[i][j] = Math.min(f[i][j], f[h][j - 1] + g[h][i - 1]);
                }
            }
        }
        return f[n][k];
    }

}
