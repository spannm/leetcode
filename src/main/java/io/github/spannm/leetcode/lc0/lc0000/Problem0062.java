package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths/">62. Unique Paths</a>.
 */
class Problem0062 extends LeetcodeProblem {

    int uniquePaths(final int _rows, final int _cols) {
        int[][] dp = new int[_rows][_cols];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, 1));

        for (int r = 1; r < _rows; r++) {
            for (int c = 1; c < _cols; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        int result = dp[_rows - 1][_cols - 1];

        dp = null;
        System.gc();

        return result;
    }

}
