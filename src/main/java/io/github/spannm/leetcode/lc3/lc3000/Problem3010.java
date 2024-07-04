package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3010. Divide an Array Into Subarrays With Minimum Cost I.
 */
class Problem3010 extends LeetcodeProblem {

    int minimumCost(int[] _nums) {
        int a = _nums[0];
        int b = 100;
        int c = 100;
        for (int i = 1; i < _nums.length; i++) {
            if (_nums[i] < b) {
                c = b;
                b = _nums[i];
            } else if (_nums[i] < c) {
                c = _nums[i];
            }
        }
        return a + b + c;
    }

}
