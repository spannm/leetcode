package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1289 extends LeetcodeProblem {

    int minFallingPathSum(int[][] _arr) {
        int size = _arr.length;
        int[][] dp = new int[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (r == 0) {
                    dp[r][c] = _arr[r][c];
                } else {
                    int prevRowMin = Integer.MAX_VALUE;
                    for (int k = 0; k < size; k++) {
                        if (k != c) {
                            prevRowMin = Math.min(dp[r - 1][k], prevRowMin);
                        }
                    }
                    dp[r][c] = _arr[r][c] + prevRowMin;
                }
            }
        }
        int result = dp[size - 1][size - 1];
        for (int i = 0; i < size; i++) {
            result = Math.min(result, dp[size - 1][i]);
        }
        return result;
    }

}
