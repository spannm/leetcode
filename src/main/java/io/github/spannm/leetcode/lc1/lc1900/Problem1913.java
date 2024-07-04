package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1913 extends LeetcodeProblem {

    int maxProductDifference(int[] _nums) {
        Arrays.sort(_nums);
        int len = _nums.length;
        return _nums[len - 1] * _nums[len - 2] - _nums[0] * _nums[1];
    }

}
