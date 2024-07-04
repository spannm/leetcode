package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1150 extends LeetcodeProblem {

    boolean isMajorityElement(int[] _nums, int _target) {
        int firstIndex = findFirstOccur(_nums, _target);
        int plusHalfIndex = firstIndex + _nums.length / 2;
        return plusHalfIndex < _nums.length && _nums[plusHalfIndex] == _target;
    }

    private int findFirstOccur(int[] _nums, int _target) {
        int left = 0;
        int right = _nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (_nums[mid] < _target) {
                left = mid + 1;
            } else if (_nums[mid] >= _target) {
                right = mid;
            }
        }
        return left;
    }

}
