package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/description/">33. Search in Rotated Sorted
 * Array</a>.
 */
class Problem0033 extends LeetcodeProblem {

    int search(int[] _nums, int _target) {
        final int len = _nums.length;

        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (_nums[mid] == _target) {
                return mid;
            }

            if (_nums[low] <= _nums[mid]) {
                if (_nums[low] <= _target && _target <= _nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (_nums[mid] <= _target && _target <= _nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}
