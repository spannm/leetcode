package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1981 extends LeetcodeProblem {
    private int         ans = Integer.MAX_VALUE;
    private boolean[][] dp;

    int minimizeTheDifference(int[][] _mat, int _target) {
        dp = new boolean[_mat.length][4900];
        memo(_mat, 0, 0, _target);
        return ans;
    }

    private void memo(int[][] _mat, int _row, int _sum, int _target) {
        if (dp[_row][_sum]) {
            return;
        }
        if (_row == _mat.length - 1) {
            for (int i = 0; i < _mat[0].length; i++) {
                ans = Math.min(ans, Math.abs(_sum + _mat[_row][i] - _target));
            }
            dp[_row][_sum] = true;
            return;
        }
        for (int i = 0; i < _mat[0].length; i++) {
            memo(_mat, _row + 1, _sum + _mat[_row][i], _target);
        }
        dp[_row][_sum] = true;
    }

}
