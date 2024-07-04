package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2789. Largest Element in an Array after Merge Operations.
 */
class Problem2789 extends LeetcodeProblem {

    long maxArrayValue(int[] nums) {
        int n = nums.length;
        long ans = nums[n - 1];
        int t = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= t) {
                t += nums[i];
            } else {
                t = nums[i];
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

}
