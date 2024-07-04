package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">215. Kth Largest Element in an Array</a>.
 */
class Problem0215 extends LeetcodeProblem {

    int findKthLargest(int[] _nums, int _k) {
        Arrays.sort(_nums);
        return _nums[_nums.length - _k];
    }

}
