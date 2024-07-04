package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0611 extends LeetcodeProblem {

    int triangleNumber(int[] _nums) {
        if (_nums == null || _nums.length == 0) {
            return 0;
        }
        Arrays.sort(_nums);
        int triplets = 0;
        for (int i = 2; i < _nums.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (_nums[i] < _nums[left] + _nums[right]) {
                    triplets += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return triplets;
    }

}
