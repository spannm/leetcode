package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1863. Sum of All Subset XOR Totals.
 */
class Problem1863 extends LeetcodeProblem {

    int subsetXORSum(int[] _nums) {
        return helper(_nums, _nums.length, 0, 0);
    }

    static int helper(int[] _nums, int _len, int idx, int _curr) {
        return idx == _len ? _curr : helper(_nums, _len,  idx + 1, _curr ^ _nums[idx]) + helper(_nums, _len, idx + 1, _curr);
    }
}
