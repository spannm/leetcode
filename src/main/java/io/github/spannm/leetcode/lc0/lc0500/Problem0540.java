package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">540. Single Element in a Sorted Array</a>.
 * <p>
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
 * element which appears exactly once.<br>
 * Return the single element that appears only once.
 */
class Problem0540 extends LeetcodeProblem {

    int singleNonDuplicate(int[] _nums) {
        return singleNonDuplicate(_nums, 0, _nums.length);
    }

    // array must have odd length
    // split array in half
    // left part (even), right part (odd, one longer than left)
    // if last two entries of left part are identical, single number must be in right part
    // continue with right
    // otherwise with left part with length increased by 1 (odd length)
    // recursive call
    // if remaining length = 3, examine and return single number
    int singleNonDuplicate(final int[] _nums, int _beginIdxIncl, int _endIdxExcl) {
        final int len = _endIdxExcl - _beginIdxIncl;

        if (len <= 3) {
            if (len == 1) {
                return _nums[_beginIdxIncl];
            }

            final int nonDup;
            if (_nums[_beginIdxIncl] == _nums[_beginIdxIncl + 1]) {
                nonDup = _nums[_endIdxExcl - 1];
            } else {
                nonDup = _nums[_beginIdxIncl];
            }
            return nonDup;
        }

        int lenLeftPart = len / 2;
        if (lenLeftPart % 2 == 1) {
            lenLeftPart++;
        }
        if (_nums[_beginIdxIncl + lenLeftPart - 2] == _nums[_beginIdxIncl + lenLeftPart - 1]) {
            return singleNonDuplicate(_nums, _beginIdxIncl + lenLeftPart, _endIdxExcl);
        } else {
            return singleNonDuplicate(_nums, _beginIdxIncl, _beginIdxIncl + lenLeftPart + 1);
        }
    }

}
