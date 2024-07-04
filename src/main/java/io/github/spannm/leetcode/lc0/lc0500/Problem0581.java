package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0581 extends LeetcodeProblem {

    int findUnsortedSubarray(int[] _nums) {
        int len = _nums.length;
        int start = -1;
        int end = -2;
        int min = _nums[len - 1];
        int max = _nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, _nums[i]);
            min = Math.min(min, _nums[len - 1 - i]);
            if (_nums[i] < max) {
                end = i;
            }
            if (_nums[len - 1 - i] > min) {
                start = len - 1 - i;
            }
        }
        return end - start + 1;
    }

}
