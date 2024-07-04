package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Objects;

class Problem1480 extends LeetcodeProblem {

    int[] runningSum(int[] _nums) {
        Objects.requireNonNull(_nums);
        if (_nums.length < 0 || _nums.length > 1000) {
            throw new IllegalArgumentException("Invalid array length");
        }
        int[] output = new int[_nums.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = _nums[i];
            if (i > 0) {
                output[i] += output[i - 1];
            }

        }
        return output;
    }

}
