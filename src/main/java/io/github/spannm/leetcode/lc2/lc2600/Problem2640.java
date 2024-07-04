package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2640. Find the Score of All Prefixes of an Array.
 */
class Problem2640 extends LeetcodeProblem {

    long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            ans[i] = nums[i] + mx + (i == 0 ? 0 : ans[i - 1]);
        }
        return ans;
    }

}
