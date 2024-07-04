package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1991 extends LeetcodeProblem {

    int findMiddleIndex(int[] _nums) {
        int middleIndex = -1;
        long sum = 0;
        for (int num : _nums) {
            sum += num;
        }
        long leftSum = 0;
        for (int i = 0; i < _nums.length; i++) {
            sum -= _nums[i];
            if (i > 0) {
                leftSum += _nums[i - 1];
            }
            if (sum == leftSum) {
                return i;
            }
        }
        return middleIndex;
    }

}
