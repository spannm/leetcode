package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv/">377. Combination Sum IV</a>.
 */
class Problem0377 extends LeetcodeProblem {

    int combinationSum4(int[] _nums, final int _target) {
        final int dpLen = _target + 1;
        int[] dp = new int[dpLen];
        dp[0] = 1;

        for (int c = 1; c < dpLen; c++) {
            for (int num : _nums) {
                if (c - num >= 0) {
                    dp[c] += dp[c - num];
                }
            }
        }
        int result = dp[_target];

        _nums = null;
        dp = null;
        System.gc();

        return result;
    }

}
