package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0303 extends LeetcodeProblem {

    static class NumArray {
        private final int[] sums;

        NumArray(int[] _nums) {
            int len = _nums.length;
            sums = new int[len];
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    sums[i] = _nums[i];
                } else {
                    sums[i] = sums[i - 1] + _nums[i];
                }
            }
        }

        int sumRange(int _i, int _j) {
            if (_i == 0) {
                return sums[_j];
            }
            return sums[_j] - sums[_i - 1];
        }
    }

}
