package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1143 extends LeetcodeProblem {

    int longestCommonSubsequence(String _text1, String _text2) {
        if (_text1 == null || _text1.isEmpty() || _text2 == null || _text2.isEmpty()) {
            return 0;
        }
        int m = _text1.length();
        int n = _text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return topDownRecursiveSolve(dp, 0, 0, _text1, _text2);
    }

    static int topDownRecursiveSolve(int[][] _dp, int _i, int _j, String _text1, String _text2) {
        if (_dp[_i][_j] != -1) {
            return _dp[_i][_j];
        }

        int option1 = topDownRecursiveSolve(_dp, _i + 1, _j, _text1, _text2);

        int firstOccurence = _text2.indexOf(_text1.charAt(_i), _j);
        int option2 = 0;
        if (firstOccurence != -1) {
            option2 = 1 + topDownRecursiveSolve(_dp, _i + 1, firstOccurence + 1, _text1, _text2);
        }
        _dp[_i][_j] = Math.max(option1, option2);
        return _dp[_i][_j];
    }

}
