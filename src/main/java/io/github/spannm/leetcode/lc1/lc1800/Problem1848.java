package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1848 extends LeetcodeProblem {

    int getMinDistance(int[] _nums, int _target, int _start) {
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < _nums.length; i++) {
            if (_nums[i] == _target) {
                if (Math.abs(_start - i) < minDiff) {
                    minDiff = Math.abs(_start - i);
                    result = minDiff;
                }
            }
        }
        return result;
    }

}
