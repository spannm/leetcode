package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0375 extends LeetcodeProblem {

    int getMoneyAmount(int _n) {
        return dp(new int[_n + 1][_n + 1], 1, _n);
    }

    private static int dp(int[][] _table, int _s, int _e) {
        if (_s >= _e) {
            return 0;
        } else if (_table[_s][_e] != 0) {
            return _table[_s][_e];
        }
        int res = Integer.MAX_VALUE;
        for (int i = _s; i <= _e; i++) {
            int temp = i + Math.max(dp(_table, _s, i - 1), dp(_table, i + 1, _e));
            res = Math.min(res, temp);
        }
        _table[_s][_e] = res;
        return res;
    }

}
