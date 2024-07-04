package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/">2369. Check if There is a
 * Valid Partition For The Array</a>.
 */
class Problem2369 extends LeetcodeProblem {

    boolean validPartition(int[] _nums) {
        int len = _nums.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        if (_nums[1] == _nums[0]) {
            dp[2] = true;
        }

        for (int i = 2; i < len; i++) {
            if (_nums[i] == _nums[i - 1]) {
                dp[i + 1] |= dp[i - 1]; // bitwise or
            }

            if (_nums[i] == _nums[i - 1] && _nums[i] == _nums[i - 2]) {
                dp[i + 1] |= dp[i - 2];
            }

            if (_nums[i] == _nums[i - 1] + 1 && _nums[i] == _nums[i - 2] + 2) {
                dp[i + 1] |= dp[i - 2];
            }
        }

        boolean result = dp[len];

        _nums = null;
        dp = null;
        System.gc();

        return result;
    }

}
