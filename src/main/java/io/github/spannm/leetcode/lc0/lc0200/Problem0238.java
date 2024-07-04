package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a>.
 */
class Problem0238 extends LeetcodeProblem {

    int[] productExceptSelf(int[] _nums) {
        int len = _nums.length;
        int[] result = new int[len];
        int zeroes = 0;
        for (int i = 0, tmp = 1; i < len; i++) {
            if (_nums[i] == 0 && ++zeroes == 2) {
                return new int[len];
            }
            result[i] = tmp;
            tmp *= _nums[i];
        }
        for (int i = len - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= _nums[i];
        }
        return result;
    }

}
