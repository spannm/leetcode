package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0576 extends LeetcodeProblem {

    int findPaths(int _x, int _y, int _maxMove, int _startRow, int _startColumn) {
        final int mod = 1000000000 + 7;
        int[][] dp = new int[_x][_y];
        dp[_startRow][_startColumn] = 1;
        int count = 0;
        for (int moves = 1; moves <= _maxMove; moves++) {
            int[][] temp = new int[_x][_y];
            for (int i = 0; i < _x; i++) {
                for (int j = 0; j < _y; j++) {
                    if (i == _x - 1) {
                        count = (count + dp[i][j]) % mod;
                    }
                    if (j == _y - 1) {
                        count = (count + dp[i][j]) % mod;
                    }
                    if (i == 0) {
                        count = (count + dp[i][j]) % mod;
                    }
                    if (j == 0) {
                        count = (count + dp[i][j]) % mod;
                    }
                    temp[i][j] = (((i > 0 ? dp[i - 1][j] : 0) + (i < _x - 1 ? dp[i + 1][j] : 0)) % mod
                        + ((j > 0 ? dp[i][j - 1] : 0) + (j < _y - 1 ? dp[i][j + 1] : 0)) % mod) % mod;
                }
            }
            dp = temp;
        }
        return count;
    }

}
