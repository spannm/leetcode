package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">75. Sort Colors</a>.
 */
class Problem0075 extends LeetcodeProblem {

    int[] sortColors(int[] _nums) {
        int i1 = 0;
        int i2 = _nums.length - 1;
        for (int i = 0; i <= i2;) {
            if (_nums[i] == 0 && i > i1) {
                swap(_nums, i, i1++);
            } else if (_nums[i] == 2 && i < i2) {
                swap(_nums, i, i2--);
            } else {
                i++;
            }
        }
        return _nums;
    }

    static void swap(int[] _nums, int _i1, int _i2) {
        int temp = _nums[_i1];
        _nums[_i1] = _nums[_i2];
        _nums[_i2] = temp;
    }

}
