package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/stone-game-iii/">1406. Stone Game III</a>.
 */
class Problem1406 extends LeetcodeProblem {

    static String stoneGameIII(final int[] _stoneValues) {
        int len = _stoneValues.length;
        Integer[] dp = new Integer[len + 1];

        int x = dfs(0, dp, _stoneValues, len);
        if (x > 0) {
            return "Alice";
        } else if (x < 0) {
            return "Bob";
        }
        return "Tie";
    }

    static int dfs(final int _sta, final Integer[] _dp, final int[] _stoneValues, final int _len) {
        if (_sta == _len) {
            return 0;
        } else if (_dp[_sta] != null) {
            return _dp[_sta];
        }

        int rslt = _stoneValues[_sta] - dfs(_sta + 1, _dp, _stoneValues, _len);
        if (_sta + 1 < _len) {
            rslt = Math.max(rslt, _stoneValues[_sta] + _stoneValues[_sta + 1]
                - dfs(_sta + 2, _dp, _stoneValues, _len));
        }
        if (_sta + 2 < _len) {
            rslt = Math.max(rslt, _stoneValues[_sta] + _stoneValues[_sta + 1] + _stoneValues[_sta + 2]
                - dfs(_sta + 3, _dp, _stoneValues, _len));
        }

        _dp[_sta] = rslt;
        return rslt;
    }

}
