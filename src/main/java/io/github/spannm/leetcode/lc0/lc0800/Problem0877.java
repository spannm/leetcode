package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0877 extends LeetcodeProblem {

    boolean stoneGame(int[] _piles) {
        int len = _piles.length;
        int[][][] dp = new int[len + 1][len + 1][2];
        for (int[][] arr : dp) {
            for (int[] num : arr) {
                Arrays.fill(num, -1);
            }
        }
        return recursion(dp, 0, len - 1, 1, _piles) > 0;
    }

    private static int recursion(int[][][] _dp, int _left, int _right, int _identifier, int[] _piles) {
        if (_left > _right) {
            return 0;
        } else if (_dp[_left][_right][_identifier] != -1) {
            return _dp[_left][_right][_identifier];
        }
        int next = Math.abs(_identifier - 1);
        if (_identifier == 1) {
            _dp[_left][_right][_identifier] = Math.max(_piles[_left] + recursion(_dp, _left + 1, _right, next, _piles), _piles[_right] + recursion(_dp, _left, _right - 1, next, _piles));
        } else {
            _dp[_left][_right][_identifier] = Math.min(-_piles[_left] + recursion(_dp, _left + 1, _right, next, _piles), -_piles[_right] + recursion(_dp, _left, _right - 1, next, _piles));
        }
        return _dp[_left][_right][_identifier];
    }

}
