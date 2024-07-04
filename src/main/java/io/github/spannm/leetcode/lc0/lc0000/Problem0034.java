package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find First and
 * Last Position of Element in Sorted Array</a>.
 */
class Problem0034 extends LeetcodeProblem {

    int[] searchRange(int[] _nums, int _target) {
        final int len = _nums.length;
        int[] range = new int[] {-1, -1};
        if (_nums.length == 0) {
            return range;
        }
        int start = 0;
        int end = len - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (_nums[mid] == _target) {
                int left = mid;
                while (left - 1 >= 0 && _nums[left] == _nums[left - 1]) {
                    left--;
                }
                range[0] = left;
                int right = mid;
                while (right + 1 < len && _nums[right] == _nums[right + 1]) {
                    right++;
                }
                range[1] = right;
                break;
            } else if (_nums[mid] < _target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (_nums[start] == _target) {
            range[0] = start;
            while (start + 1 < len && _nums[start] == _nums[start + 1]) {
                start++;
            }
            range[1] = start;
        } else if (_nums[end] == _target) {
            range[1] = end;
            while (end - 1 >= 0 && _nums[end] == _nums[end - 1]) {
                end--;
            }
            range[0] = end;
        }
        return range;
    }

}
