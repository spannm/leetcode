package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1827 extends LeetcodeProblem {

    int minOperations(int[] _nums) {
        int minsOps = 0;
        for (int i = 1; i < _nums.length; i++) {
            if (_nums[i] <= _nums[i - 1]) {
                minsOps += _nums[i - 1] - _nums[i] + 1;
                _nums[i] = _nums[i - 1] + 1;
            }
        }
        return minsOps;
    }

}
