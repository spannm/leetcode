package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/">16. 3Sum Closest</a>.
 */
class Problem0016 extends LeetcodeProblem {

    int threeSumClosest(int[] _nums, int _target) {
        final int len = _nums.length;
        Arrays.sort(_nums);
        int sum = _nums[0] + _nums[1] + _nums[2];
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int currSum = _nums[i] + _nums[l] + _nums[r];
                if (Math.abs(currSum - _target) < Math.abs(sum - _target)) {
                    sum = currSum;
                    if (sum == _target) {
                        return sum;
                    }
                } else if (_target > currSum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return sum;
    }

}
