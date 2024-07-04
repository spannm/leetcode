package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2656. Maximum Sum With Exactly K Elements.
 */
class Problem2656 extends LeetcodeProblem {

    int maximizeSum(int[] nums, int k) {
        int x = 0;
        for (int v : nums) {
            x = Math.max(x, v);
        }
        return k * x + k * (k - 1) / 2;
    }

}
