package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2057 extends LeetcodeProblem {

    int smallestEqual(int[] _nums) {
        for (int i = 0; i < _nums.length; i++) {
            if (i % 10 == _nums[i]) {
                return i;
            }
        }
        return -1;
    }

}
