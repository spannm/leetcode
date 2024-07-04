package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2016 extends LeetcodeProblem {

    int maximumDifference(int[] _nums) {
        int maxDiff = -1;
        for (int i = 0; i < _nums.length - 1; i++) {
            for (int j = i + 1; j < _nums.length; j++) {
                if (_nums[j] >= _nums[i]) {
                    maxDiff = Math.max(_nums[j] - _nums[i], maxDiff);
                }
            }
        }
        return maxDiff;
    }

}
