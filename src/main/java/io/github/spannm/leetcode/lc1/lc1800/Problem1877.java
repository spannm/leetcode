package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1877 extends LeetcodeProblem {

    int minPairSum(int[] _nums) {
        Arrays.sort(_nums);
        int maxSum = 0;
        for (int left = 0, right = _nums.length - 1; left < right; left++, right--) {
            maxSum = Math.max(maxSum, _nums[left] + _nums[right]);
        }
        return maxSum;
    }

}
