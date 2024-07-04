package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">153. Find Minimum in Rotated Sorted
 * Array</a>.
 */
class Problem0153 extends LeetcodeProblem {

    int findMin(int[] _nums) {
        int left = 0;
        int right = _nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == left || mid == right) {
                break;
            } else if (_nums[mid] > _nums[left] && _nums[mid] > _nums[right]) {
                left = mid + 1;
            } else if (_nums[mid] < _nums[right] && _nums[mid] > _nums[left]) {
                right = mid - 1;
            } else if (_nums[mid] < _nums[left] && _nums[mid] < _nums[right]) {
                right = mid;
            }
        }
        return right >= 0 ? Math.min(_nums[left], _nums[right]) : _nums[left];
    }

}
