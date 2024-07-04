package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1099 extends LeetcodeProblem {

    int twoSumLessThanK(int[] _arr, int _k) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < _arr.length - 1; i++) {
            for (int j = i + 1; j < _arr.length; j++) {
                if (_arr[i] + _arr[j] < _k) {
                    maxSum = Math.max(maxSum, _arr[i] + _arr[j]);
                }
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }

}
