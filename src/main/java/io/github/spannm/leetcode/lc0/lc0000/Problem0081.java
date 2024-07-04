package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/">81. Search in Rotated Sorted Array II</a>.
 */
class Problem0081 extends LeetcodeProblem {

    boolean search(int[] _nums, int _target) {
        final int len = _nums.length;
        int pivot = 0;
        for (int i = 0; i < len - 1; i++) {
            if (_nums[i] > _nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        return binSearch(_nums, 0, pivot, _target) >= 0
            || binSearch(_nums, pivot + 1, len - 1, _target) > 0;
    }

    static int binSearch(int[] _nums, int _l, int _r, int _target) {
        while (_l <= _r) {
            int mid = (_l + _r) / 2;
            if (_nums[mid] == _target) {
                return mid;
            } else if (_nums[mid] < _target) {
                _l = mid + 1;
            } else {
                _r = mid - 1;
            }
        }
        return -1;
    }

}
