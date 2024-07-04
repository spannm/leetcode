package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0370 extends LeetcodeProblem {

    int[] getModifiedArray(int _length, int[][] _updates) {
        int[] nums = new int[_length];
        for (int[] update : _updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            nums[start] += inc;
            if (end < _length - 1) {
                nums[end + 1] -= inc;
            }
        }

        int sum = 0;
        for (int i = 0; i < _length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

}
