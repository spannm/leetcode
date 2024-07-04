package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/">53. Maximum Subarray</a>.
 */
class Problem0053 extends LeetcodeProblem {

    int maxSubArray(int[] _nums) {
        int globalMax = _nums[0];
        int currentMax = _nums[0];
        for (int i = 1; i < _nums.length; i++) {
            currentMax = Math.max(_nums[i], currentMax + _nums[i]);
            globalMax = Math.max(currentMax, globalMax);
        }
        return globalMax;
    }

}
