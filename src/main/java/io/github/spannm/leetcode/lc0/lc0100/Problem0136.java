package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/single-number/">136. Single Number</a>.
 */
class Problem0136 extends LeetcodeProblem {

    int singleNumber(int[] _nums) {
        int len = _nums.length;
        if (len == 1) {
            return _nums[0];
        }

        int n = _nums[0];
        for (int i = 1; i < len; i++) {
            n = n ^ _nums[i]; // bitwise exclusive OR
        }
        return n;
    }

}
