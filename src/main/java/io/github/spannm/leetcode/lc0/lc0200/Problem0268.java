package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0268 extends LeetcodeProblem {

    int missingNumber(int[] _nums) {
        int i = 0;
        int xor = 0;
        for (; i < _nums.length; i++) {
            xor ^= i ^ _nums[i];
        }
        return xor ^ i;
    }

}
