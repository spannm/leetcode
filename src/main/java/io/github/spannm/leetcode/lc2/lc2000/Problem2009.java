package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/">2009. Minimum Number
 * of Operations to Make Array Continuous</a>.
 */
class Problem2009 extends LeetcodeProblem {

    int minOperations(int[] _nums) {
        int len = _nums.length;
        if (len <= 1) {
            return 0;
        }
        Arrays.sort(_nums);
        if (_nums[0] == _nums[len - 1]) { // unique
            return 0;
        }

        int uq = 1;

        // Remove duplicate elements in the sorted array
        for (int i = 1; i < len; i++) {
            if (_nums[i] != _nums[i - 1]) {
                _nums[uq++] = _nums[i];
            }
        }

        int ops = len;

        // Use a sliding window to find the minimum number of operations
        for (int i = 0, j = 0; i < uq; i++) {
            while (j < uq && _nums[j] - _nums[i] <= len - 1) {
                j++;
            }
            ops = Math.min(ops, len - (j - i));
        }

        return ops;
    }

}
