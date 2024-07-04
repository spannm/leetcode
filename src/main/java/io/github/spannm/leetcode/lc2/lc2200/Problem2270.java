package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2270 extends LeetcodeProblem {

    int waysToSplitArray(int[] _nums) {
        long[] presum = new long[_nums.length];
        for (int i = 0; i < _nums.length; i++) {
            if (i == 0) {
                presum[i] = _nums[i];
            } else {
                presum[i] = presum[i - 1] + _nums[i];
            }
        }
        int ways = 0;
        long firstHalf = presum[0];
        long secondHalf = presum[_nums.length - 1] - presum[0];
        for (int i = 0; i < _nums.length - 1;) {
            if (firstHalf >= secondHalf) {
                ways++;
            }
            i++;
            if (i < _nums.length - 1) {
                firstHalf = presum[i];
                secondHalf = presum[_nums.length - 1] - presum[i];
            }
        }
        return ways;
    }

}
