package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2006 extends LeetcodeProblem {

    int countKDifference(int[] _nums, int _k) {
        int pairs = 0;
        for (int i = 0; i < _nums.length - 1; i++) {
            for (int j = i + 1; j < _nums.length; j++) {
                if (Math.abs(_nums[i] - _nums[j]) == _k) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

}
