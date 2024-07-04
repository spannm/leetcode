package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0280 extends LeetcodeProblem {

    void wiggleSort(int[] _nums) {
        for (int i = 1; i < _nums.length; i++) {
            if (i % 2 == 0 && _nums[i] > _nums[i - 1] || i % 2 == 1 && _nums[i] < _nums[i - 1]) {
                swap(_nums, i);
            }
        }
    }

    void swap(int[] _nums, int _i) {
        int temp = _nums[_i - 1];
        _nums[_i - 1] = _nums[_i];
        _nums[_i] = temp;
    }

}
