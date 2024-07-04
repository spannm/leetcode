package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/"> 1420.
 * Build Array Where You Can Find The Maximum Exactly K Comparisons</a>.
 */
class Problem1420 extends LeetcodeProblem {

    int numOfArrays(int _n, int _m, int _k) {
        return numOfArrays(_n, _m, _k, 0, 0, 0, new Integer[_n + 1][_m + 1][_k + 1]);
    }

    static int numOfArrays(int _n, int _m, int _k, int _index, int _cost, int _prev, Integer[][][] _dp) {
        if (_index == _n) {
            return _cost == _k ? 1 : 0;
        } else if (_cost > _k) {
            return 0;
        } else if (_dp[_index][_prev][_cost] != null) {
            return _dp[_index][_prev][_cost];
        }
        long ans = 0;
        if (_cost < _k) {
            for (int i = _prev + 1; i <= _m; i++) {
                ans = (ans + numOfArrays(_n, _m, _k, _index + 1, _cost + 1, i, _dp)) % 1000000007;
            }
        }

        for (int i = 1; i <= _prev; i++) {
            ans = (ans + numOfArrays(_n, _m, _k, _index + 1, _cost, _prev, _dp)) % 1000000007;
        }

        return _dp[_index][_prev][_cost] = (int) ans;
    }

}
