package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1708 extends LeetcodeProblem {

    int[] largestSubarray(int[] _nums, int _k) {
        int max = _nums[0];
        int beginIndex = 0;
        for (int i = 1; i <= _nums.length - _k; i++) {
            if (_nums[i] > max) {
                max = _nums[i];
                beginIndex = i;
            }
        }
        int[] result = new int[_k];
        for (int i = beginIndex, j = 0; i < i + _k && j < _k; i++) {
            result[j++] = _nums[i];
        }
        return result;
    }

}
