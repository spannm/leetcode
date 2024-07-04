package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem1685 extends LeetcodeProblem {

    int[] getSumAbsoluteDifferences(int[] _nums) {
        int len = _nums.length;
        int[] preSums = new int[len];
        for (int i = 1; i < len; i++) {
            preSums[i] = preSums[i - 1] + _nums[i - 1];
        }

        int[] postSums = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            postSums[i] = postSums[i + 1] + _nums[i + 1];
        }

        return IntStream.range(0, len)
            .map(i -> _nums[i] * i - preSums[i] + postSums[i] - _nums[i] * (len - i - 1)).toArray();
    }

}
