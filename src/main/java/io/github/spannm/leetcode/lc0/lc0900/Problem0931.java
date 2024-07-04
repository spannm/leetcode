package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 931. Minimum Falling Path Sum.
 */
class Problem0931 extends LeetcodeProblem {

    int minFallingPathSum(int[][] _arr) {
        int size = _arr.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0) {
                    dp[i][j] = _arr[i][j];
                } else {
                    int lastRow = dp[i - 1][j];
                    if (j - 1 >= 0) {
                        lastRow = Math.min(dp[i - 1][j - 1], lastRow);
                    }
                    if (j + 1 < size) {
                        lastRow = Math.min(dp[i - 1][j + 1], lastRow);
                    }
                    dp[i][j] = lastRow + _arr[i][j];
                }
            }
        }
        return java.util.Arrays.stream(dp[size - 1], 0, size).min().orElse(-1);
    }

}
