package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1012. Numbers With Repeated Digits.
 */
class Problem1012 extends LeetcodeProblem {

    private final int[]       nums = new int[11];
    private final Integer[][] dp   = new Integer[11][1 << 11];

    int numDupDigitsAtMostN(int _n) {
        return _n - f(_n);
    }

    private int f(int _n) {
        int i = -1;
        for (; _n > 0; _n /= 10) {
            nums[++i] = _n % 10;
        }
        return dfs(i, 0, true, true);
    }

    private int dfs(int _pos, int _mask, boolean _lead, boolean _limit) {
        if (_pos < 0) {
            return _lead ? 0 : 1;
        } else if (!_lead && !_limit && dp[_pos][_mask] != null) {
            return dp[_pos][_mask];
        }
        int ans = 0;
        int up = _limit ? nums[_pos] : 9;
        for (int i = 0; i <= up; i++) {
            if ((_mask >> i & 1) == 1) {
                continue;
            }
            if (i == 0 && _lead) {
                ans += dfs(_pos - 1, _mask, _lead, _limit && i == up);
            } else {
                ans += dfs(_pos - 1, _mask | 1 << i, false, _limit && i == up);
            }
        }
        if (!_lead && !_limit) {
            dp[_pos][_mask] = ans;
        }
        return ans;
    }

}
