package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1984 extends LeetcodeProblem {

    int minimumDifference(int[] _nums, int _k) {
        Arrays.sort(_nums);
        int minDiff = _nums[_nums.length - 1];
        for (int i = 0; i <= _nums.length - _k; i++) {
            minDiff = Math.min(minDiff, _nums[i + _k - 1] - _nums[i]);
        }
        return minDiff;
    }

}
