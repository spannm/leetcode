package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 945. Minimum Increment to Make Array Unique.
 */
class Problem0945 extends LeetcodeProblem {

    int minIncrementForUnique(int[] _nums) {
        Arrays.sort(_nums);
        int result = 0;
        for (int i = 1; i < _nums.length; i++) {
            if (_nums[i] <= _nums[i - 1]) {
                int d = _nums[i - 1] - _nums[i] + 1;
                _nums[i] += d;
                result += d;
            }
        }
        return result;
    }

}
