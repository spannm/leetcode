package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2393. Count Strictly Increasing Subarrays.
 */
class Problem2393 extends LeetcodeProblem {

    long countSubarrays(int[] nums) {
        long ans = 0;
        int i = 0;
        long n = nums.length;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] > nums[j - 1]) {
                j++;
            }
            long cnt = j - i;
            ans += (1 + cnt) * cnt / 2;
            i = j;
        }
        return ans;
    }

}
