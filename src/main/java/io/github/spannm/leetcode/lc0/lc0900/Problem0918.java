package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0918 extends LeetcodeProblem {

    int maxSubarraySumCircular(int[] _nums) {
        int[] prefixSums;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < _nums.length; i++) {
            prefixSums = new int[_nums.length];
            for (int j = i, k = 0; j < i + _nums.length; j++) {
                if (k == 0) {
                    prefixSums[k] = _nums[(j + _nums.length) % _nums.length];
                } else {
                    prefixSums[k] = prefixSums[k - 1] + _nums[(j + _nums.length) % _nums.length];
                }
                maxSum = Math.max(maxSum, prefixSums[k++]);
            }
        }
        return maxSum;
    }

}
