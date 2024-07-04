package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1486 extends LeetcodeProblem {

    int xorOperation(int _n, int _start) {
        int[] nums = new int[_n];
        for (int i = 0; i < _n; i++) {
            nums[i] = _start + 2 * i;
        }
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
