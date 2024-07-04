package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/">35. Search Insert Position</a>.
 */
class Problem0035 extends LeetcodeProblem {

    int searchInsert(int[] _nums, int _target) {
        return searchInsert(_nums, _target, 0, _nums.length - 1);
    }

    int searchInsert(int[] _nums, int _target, int _fromIndex, int _toIndex) {
        if (_target < _nums[_fromIndex]) {
            return _fromIndex;
        } else if (_target > _nums[_toIndex]) {
            return _toIndex + 1;
        }

        final int remaining = _toIndex - _fromIndex + 1;

        if (remaining <= 1) {
            if (remaining == 0) {
                return _fromIndex;
            }
            return _nums[_fromIndex] < _target ? _fromIndex + 1 : _fromIndex;
        }

        final int halfIndex = remaining / 2 + _fromIndex;
        if (_nums[halfIndex] == _target) {
            return halfIndex;
        }

        if (_nums[halfIndex] < _target) {
            // use right part of subarray
            return searchInsert(_nums, _target, halfIndex + 1, _toIndex);
        } else {
            // use left part of subarray
            return searchInsert(_nums, _target, _fromIndex, halfIndex == _toIndex ? halfIndex - 1 : halfIndex);
        }
    }

}
