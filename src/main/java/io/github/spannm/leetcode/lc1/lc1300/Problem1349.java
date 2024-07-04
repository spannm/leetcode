package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1349 extends LeetcodeProblem {

    int maxStudents(char[][] _seats) {
        int m = _seats.length;
        int n = _seats[0].length;
        int[] validRows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                validRows[i] = (validRows[i] << 1) + (_seats[i][j] == '.' ? 1 : 0);
            }
        }
        int stateSize = 1 << n;
        int[][] dp = new int[m][stateSize];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < stateSize; j++) {
                if ((j & validRows[i]) == j && (j & j << 1) == 0) {
                    if (i == 0) {
                        dp[i][j] = Integer.bitCount(j);
                    } else {
                        for (int k = 0; k < stateSize; k++) {
                            if ((k << 1 & j) == 0 && (j << 1 & k) == 0 && dp[i - 1][k] != -1) {
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Integer.bitCount(j));
                            }
                        }
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

}
