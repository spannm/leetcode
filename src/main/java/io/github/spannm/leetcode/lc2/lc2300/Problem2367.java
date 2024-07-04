package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2367 extends LeetcodeProblem {

    int arithmeticTriplets(int[] _nums, int _diff) {
        int count = 0;
        for (int i = 0; i < _nums.length - 2; i++) {
            for (int j = i + 1; j < _nums.length - 1; j++) {
                for (int k = j + 1; k < _nums.length; k++) {
                    if (_nums[j] - _nums[i] == _nums[k] - _nums[j] && _nums[k] - _nums[j] == _diff) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
