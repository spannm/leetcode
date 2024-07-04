package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/rotate-array/">189. Rotate Array</a>.
 */
class Problem0189 extends LeetcodeProblem {

    void rotate(int[] _nums, int _steps) {
        final int len = _nums.length;
        if (len == 0) {
            return;
        }
        _steps %= len; // minimize steps to avoid redundant rotations
        if (_steps == 0) {
            return; // no rotation
        }
        if (_steps < 0) { // support negative rotation
            _steps += len;
        }

        reverse(_nums, 0, len - _steps - 1);
        reverse(_nums, len - _steps, len - 1);
        reverse(_nums, 0, len - 1);
    }

    static void reverse(int[] _nums, int _leftIdx, int _rightIdx) {
        while (_leftIdx < _rightIdx) {
            int temp = _nums[_leftIdx];
            _nums[_leftIdx] = _nums[_rightIdx];
            _nums[_rightIdx] = temp;
            _leftIdx++;
            _rightIdx--;
        }
    }

}
