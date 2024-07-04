package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2239 extends LeetcodeProblem {

    int findClosestNumber(int[] _nums) {
        int ans = _nums[0];
        int minDiff = Math.abs(_nums[0]);
        for (int i = 1; i < _nums.length; i++) {
            int diff = Math.abs(_nums[i]);
            if (diff < minDiff) {
                minDiff = diff;
                ans = _nums[i];
            } else if (diff == minDiff && _nums[i] > ans) {
                ans = _nums[i];
            }
        }
        return ans;
    }

}
