package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2221. Find Triangular Sum of an Array.
 */
class Problem2221 extends LeetcodeProblem {

    int triangularSum(int[] nums) {
        int n = nums.length;
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }

}
