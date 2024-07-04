package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2587. Rearrange Array to Maximize Prefix Score.
 */
class Problem2587 extends LeetcodeProblem {

    int maxScore(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += nums[n - i - 1];
            if (s <= 0) {
                return i;
            }
        }
        return n;
    }

}
