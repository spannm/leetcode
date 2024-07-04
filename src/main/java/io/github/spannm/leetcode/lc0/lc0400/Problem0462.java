package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0462 extends LeetcodeProblem {

    int minMoves2(int[] _nums) {
        Arrays.sort(_nums);
        int result = 0;
        int result1 = 0;
        if (_nums.length % 2 != 0) {
            int median = _nums[_nums.length / 2];
            for (int n : _nums) {
                result += Math.abs(n - median);
            }
            return result;
        } else {
            int median1 = _nums[_nums.length / 2];
            for (int n : _nums) {
                result1 += Math.abs(n - median1);
            }
            int result2 = 0;
            int median2 = _nums[_nums.length / 2 - 1];
            for (int n : _nums) {
                result2 += Math.abs(n - median2);
            }
            result1 = Math.min(result1, result2);
            return result1;
        }
    }

}
