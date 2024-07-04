package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1753 extends LeetcodeProblem {

    int maximumScore(int _a, int _b, int _c) {
        int[] nums = new int[] {_a, _b, _c};
        Arrays.sort(nums);
        if (nums[0] + nums[1] < nums[2]) {
            return nums[0] + nums[1];
        } else {
            return (nums[0] + nums[1] + nums[2]) / 2;
        }
    }

}
