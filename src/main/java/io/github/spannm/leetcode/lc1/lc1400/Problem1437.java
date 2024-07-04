package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1437 extends LeetcodeProblem {

    boolean kLengthApart(int[] _nums, int _k) {
        int lastOneIndex = _nums[0] == 1 ? 0 : -1;
        for (int i = 1; i < _nums.length; i++) {
            if (_nums[i] == 1) {
                if (i - lastOneIndex <= _k) {
                    return false;
                } else {
                    lastOneIndex = i;
                }
            }
        }
        return true;
    }

}
