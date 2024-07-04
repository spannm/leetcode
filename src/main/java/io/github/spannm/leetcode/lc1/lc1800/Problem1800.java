package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1800 extends LeetcodeProblem {

    int maxAscendingSum(int[] _nums) {
        int maxSum = _nums[0];
        for (int i = 0, j = i + 1; i < _nums.length - 1 && j < _nums.length; j++) {
            int sum = _nums[j - 1];
            while (j < _nums.length && _nums[j] - _nums[j - 1] > 0) {
                sum += _nums[j];
                j++;
            }
            i = j;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

}
