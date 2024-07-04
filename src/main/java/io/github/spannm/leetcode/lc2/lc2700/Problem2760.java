package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2760. Longest Even Odd Subarray With Threshold.
 */
class Problem2760 extends LeetcodeProblem {

    int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        for (int l = 0, n = nums.length; l < n;) {
            if (nums[l] % 2 == 0 && nums[l] <= threshold) {
                int r = l + 1;
                while (r < n && nums[r] % 2 != nums[r - 1] % 2 && nums[r] <= threshold) {
                    r++;
                }
                ans = Math.max(ans, r - l);
                l = r;
            } else {
                l++;
            }
        }
        return ans;
    }

}
