package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2401. Longest Nice Subarray.
 */
class Problem2401 extends LeetcodeProblem {

    int longestNiceSubarray(int[] nums) {
        int ans = 0;
        int mask = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while ((mask & nums[i]) != 0) {
                mask ^= nums[j++];
            }
            ans = Math.max(ans, i - j + 1);
            mask |= nums[i];
        }
        return ans;
    }

}
