package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2460. Apply Operations to an Array.
 */
class Problem2460 extends LeetcodeProblem {

    int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }
        }
        int[] ans = new int[n];
        int i = 0;
        for (int x : nums) {
            if (x > 0) {
                ans[i++] = x;
            }
        }
        return ans;
    }

}
