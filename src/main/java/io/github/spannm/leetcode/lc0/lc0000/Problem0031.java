package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/next-permutation/">31. Next Permutation</a>.
 */
class Problem0031 extends LeetcodeProblem {

    void nextPermutation(int[] _nums) {
        final int len = _nums.length;
        int i = len - 2;
        while (i >= 0 && _nums[i] >= _nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && _nums[i] >= _nums[j]) {
                j--;
            }
            swap(_nums, i, j);
        }

        reverse(_nums, i + 1);
    }

    static void swap(int[] _nums, int _i1, int _i2) {
        int tmp = _nums[_i1];
        _nums[_i1] = _nums[_i2];
        _nums[_i2] = tmp;
    }

    static void reverse(int[] _nums, int _start) {
        int end = _nums.length - 1;
        while (_start <= end) {
            int tmp = _nums[_start];
            _nums[_start++] = _nums[end];
            _nums[end--] = tmp;
        }
    }

}
