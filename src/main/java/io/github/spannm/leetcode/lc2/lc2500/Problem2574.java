package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2574. Left and Right Sum Differences.
 */
class Problem2574 extends LeetcodeProblem {

    int[] leftRigthDifference(int[] nums) {
        int left = 0;
        int right = Arrays.stream(nums).sum();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            right -= nums[i];
            ans[i] = Math.abs(left - right);
            left += nums[i];
        }
        return ans;
    }

}
