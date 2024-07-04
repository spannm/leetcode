package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0162 extends LeetcodeProblem {

    int findPeakElement(int[] _nums) {
        final int len = _nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (_nums[mid] < _nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left == len - 1 || _nums[left] > _nums[left + 1] ? left : right;
    }

}
