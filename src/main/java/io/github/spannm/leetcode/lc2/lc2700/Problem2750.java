package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2750. Ways to Split Array Into Good Subarrays.
 */
class Problem2750 extends LeetcodeProblem {

    int numberOfGoodSubarraySplits(int[] nums) {
        final int mod = (int) 1e9 + 7;
        int ans = 1;
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (j > -1) {
                ans = (int) ((long) ans * (i - j) % mod);
            }
            j = i;
        }
        return j == -1 ? 0 : ans;
    }

}
