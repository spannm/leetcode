package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/count-all-possible-routes/">1575. Count All Possible Routes</a>.
 */
class Problem1575 extends LeetcodeProblem {

    int countRoutes(final int[] _locations, final int _start, final int _finish, final int _fuel) {
        final int[][] dp = new int[_locations.length][_fuel + 1];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return dfs(_locations, _start, _finish, _fuel, dp);
    }

    static int dfs(final int[] _locations, final int _current, final int _finish, final int _fuel, final int[][] _dp) {
        if (_fuel < 0) {
            return 0;
        } else if (_dp[_current][_fuel] != -1) {
            return _dp[_current][_fuel];
        }

        int result = 0;

        if (_current == _finish) {
            result++;
        }

        for (int l = 0; l < _locations.length; l++) {
            if (l != _current) {
                final int cost = Math.abs(_locations[l] - _locations[_current]);
                final int nextTrip = dfs(_locations, l, _finish, _fuel - cost, _dp);
                result += nextTrip;
                result = result % 1000000007;
            }
        }

        _dp[_current][_fuel] = result;

        return result;
    }

}
