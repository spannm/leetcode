package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">167. Two Sum II - Input Array Is
 * Sorted</a>.
 */
class Problem0167 extends LeetcodeProblem {

    int[] twoSum(final int[] _nums, final int _target) {
        int idxLower = 0;
        int idxUpper = _nums.length - 1;
        int sum = 0;

        while (idxLower < idxUpper) {
            sum = _nums[idxLower] + _nums[idxUpper];
            if (sum == _target) {
                return new int[] {++idxLower, ++idxUpper};
            } else if (sum > _target) {
                idxUpper--;
            } else {
                idxLower++;
            }
        }
        return new int[0];
    }

}
