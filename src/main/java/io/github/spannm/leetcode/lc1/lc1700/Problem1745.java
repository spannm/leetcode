package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1745 extends LeetcodeProblem {

    boolean checkPartitioning(String _s) {
        int n = _s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (_s.charAt(i) == _s.charAt(j)) {
                    dp[i][j] = i + 1 > j - 1 || dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

}
