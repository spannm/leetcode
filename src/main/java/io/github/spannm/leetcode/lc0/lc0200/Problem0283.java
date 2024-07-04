package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">283. Move Zeroes</a>.
 */
class Problem0283 extends LeetcodeProblem {

    void moveZeroes(int[] _nums) {
        int len = _nums.length;
        int snowBallSize = 0;

        for (int i = 0; i < len; i++) {
            if (_nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                int t = _nums[i];
                _nums[i - snowBallSize] = t;
                _nums[i] = 0;
            }
        }
    }

}
