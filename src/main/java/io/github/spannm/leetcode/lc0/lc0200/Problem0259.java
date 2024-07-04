package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0259 extends LeetcodeProblem {

    int threeSumSmaller(int[] _nums, int _target) {
        if (_nums == null || _nums.length == 0) {
            return 0;
        }
        int result = 0;
        Arrays.sort(_nums);
        for (int i = 0; i < _nums.length - 2; i++) {
            int left = i + 1;
            int right = _nums.length - 1;
            while (left < right) {
                int sum = _nums[i] + _nums[left] + _nums[right];
                if (sum < _target) {
                    result += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

}
