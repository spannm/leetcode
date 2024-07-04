package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0154 extends LeetcodeProblem {

    int findMin(int[] _nums) {
        int left = 0;
        int right = _nums.length - 1;
        while (left < right) {
            while (left + 1 < right && _nums[left] == _nums[left + 1]) {
                left++;
            }
            while (right - 1 > left && _nums[right - 1] == _nums[right]) {
                right--;
            }
            int mid = left + (right - left) / 2;
            if (mid == left || mid == right) {
                break;
            } else if (_nums[mid] < _nums[right]) {
                right = mid;
            } else if (_nums[mid] < _nums[left]) {
                left = mid;
            } else if (_nums[mid] > _nums[right]) {
                left = mid + 1;
            }
        }
        return right >= 0 && _nums[right] < _nums[left] ? _nums[right] : _nums[left];
    }

}
