package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0221 extends LeetcodeProblem {

    int maximalSquare(char[][] _matrix) {
        if (_matrix == null || _matrix.length == 0) {
            return 0;
        }
        int rowCount = _matrix.length;
        int colCount = _matrix[0].length;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[rowCount][colCount];
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (r == 0 || c == 0) {
                    dp[r][c] = _matrix[r][c] == '1' ? 1 : 0;
                } else {
                    if (_matrix[r][c] == '0') {
                        dp[r][c] = 0;
                    } else {
                        dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1;
                    }
                }
                max = Math.max(max, dp[r][c]);
            }
        }
        return max * max;
    }

}
