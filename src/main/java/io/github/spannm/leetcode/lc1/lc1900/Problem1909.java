package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1909 extends LeetcodeProblem {

    boolean canBeIncreasing(int[] _nums) {
        boolean removed = false;
        for (int i = 1; i < _nums.length; i++) {
            if (_nums[i] <= _nums[i - 1]) {
                if (removed) {
                    return false;
                } else {
                    removed = true;
                }
                if (i > 1 && _nums[i] <= _nums[i - 2]) {
                    _nums[i] = _nums[i - 1];
                }
            }
        }
        return true;
    }

}
