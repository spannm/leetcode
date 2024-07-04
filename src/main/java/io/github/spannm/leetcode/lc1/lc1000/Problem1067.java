package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1067. Digit Count in Range.
 */
class Problem1067 extends LeetcodeProblem {

    private int           d;
    private final int[]   a  = new int[11];
    private final int[][] dp = new int[11][11];

    int digitsCount(int _d, int _low, int _high) {
        d = _d;
        return f(_high) - f(_low - 1);
    }

    private int f(int _n) {
        for (var e : dp) {
            Arrays.fill(e, -1);
        }
        int len = 0;
        while (_n > 0) {
            a[len++] = _n % 10;
            _n /= 10;
        }
        return dfs(len, 0, true, true);
    }

    private int dfs(int _pos, int _cnt, boolean _lead, boolean _limit) {
        if (_pos <= 0) {
            return _cnt;
        } else if (!_lead && !_limit && dp[_pos][_cnt] != -1) {
            return dp[_pos][_cnt];
        }
        int up = _limit ? a[_pos] : 9;
        int ans = 0;
        for (int i = 0; i <= up; i++) {
            if (i == 0 && _lead) {
                ans += dfs(_pos - 1, _cnt, _lead, _limit && i == up);
            } else {
                ans += dfs(_pos - 1, _cnt + (i == d ? 1 : 0), false, _limit && i == up);
            }
        }
        if (!_lead && !_limit) {
            dp[_pos][_cnt] = ans;
        }
        return ans;
    }

}
