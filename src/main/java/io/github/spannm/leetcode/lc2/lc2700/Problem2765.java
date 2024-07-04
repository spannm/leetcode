package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2765. Longest Alternating Subarray.
 */
class Problem2765 extends LeetcodeProblem {

    int alternatingSubarray(int[] nums) {
        int ans = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = 1;
            int j = i;
            for (; j + 1 < n && nums[j + 1] - nums[j] == k; j++) {
                k *= -1;
            }
            if (j - i + 1 > 1) {
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }

}
