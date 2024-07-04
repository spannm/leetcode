package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0312 extends LeetcodeProblem {

    int maxCoins(int[] _nums) {
        int[] input = new int[_nums.length + 2];
        int n = 1;
        for (int x : _nums) {
            if (x > 0) {
                input[n++] = x;
            }
        }
        input[0] = 1;
        input[n++] = 1;

        return burst(new int[n][n], input, 0, n - 1);
    }

    static int burst(int[][] _memo, int[] _nums, int _left, int _right) {
        if (_left + 1 == _right) {
            return 0;
        } else if (_memo[_left][_right] > 0) {
            return _memo[_left][_right];
        }
        int ans = 0;
        for (int i = _left + 1; i < _right; i++) {
            ans = Math.max(ans, _nums[_left] * _nums[i] * _nums[_right] + burst(_memo, _nums, _left, i) + burst(_memo, _nums, i, _right));
        }
        _memo[_left][_right] = ans;
        return ans;
    }

}
