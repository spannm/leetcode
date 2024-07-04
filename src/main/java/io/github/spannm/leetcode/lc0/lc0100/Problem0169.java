package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/majority-element/">169. Majority Element</a>.
 */
class Problem0169 extends LeetcodeProblem {

    int majorityElement(int[] _nums) {
        Arrays.sort(_nums);
        return _nums[_nums.length / 2];
    }

}
