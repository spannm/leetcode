package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2428. Maximum Sum of an Hourglass.
 */
class Problem2428 extends LeetcodeProblem {

    int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int s = -grid[i][j - 1] - grid[i][j + 1];
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        s += grid[x][y];
                    }
                }
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }

}
