package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.math.BigInteger;

/**
 * 2719. Count of Integers.
 */
class Problem2719 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;
    private String           num;
    private int              min;
    private int              max;
    private Integer[][]      f;

    int count(String _num1, String _num2, int _minSum, int _maxSum) {
        min = _minSum;
        max = _maxSum;
        num = _num2;
        f = new Integer[23][220];
        int ans = dfs(0, 0, true);
        num = new BigInteger(_num1).subtract(BigInteger.ONE).toString();
        f = new Integer[23][220];
        ans = (ans - dfs(0, 0, true) + MOD) % MOD;
        return ans;
    }

    int dfs(int _pos, int _s, boolean _limit) {
        if (_pos >= num.length()) {
            return _s >= min && _s <= max ? 1 : 0;
        } else if (!_limit && f[_pos][_s] != null) {
            return f[_pos][_s];
        }
        int ans = 0;
        int up = _limit ? num.charAt(_pos) - '0' : 9;
        for (int i = 0; i <= up; i++) {
            ans = (ans + dfs(_pos + 1, _s + i, _limit && i == up)) % MOD;
        }
        if (!_limit) {
            f[_pos][_s] = ans;
        }
        return ans;
    }

}
