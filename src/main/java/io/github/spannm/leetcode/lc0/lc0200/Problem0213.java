package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0213 extends LeetcodeProblem {

    int rob(int[] _nums) {
        int len = _nums.length;
        return len == 1 ? _nums[0] : Math.max(rob(_nums, 0, len - 1), rob(_nums, 1, len));
    }

    static int rob(int[] _nums, int _start, int _end) {
        int[] dp = new int[_nums.length];
        dp[_start] = _nums[_start];
        if (_end - _start <= 1) {
            return _nums[_start];
        }
        dp[_start + 1] = Math.max(_nums[_start], _nums[_start + 1]);
        for (int i = _start + 2; i < _end; i++) {
            dp[i] = Math.max(dp[i - 2] + _nums[i], dp[i - 1]);
        }
        return dp[_end - 1];
    }

}
