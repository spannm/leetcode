package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2219. Maximum Sum Score of Array.
 */
class Problem2219 extends LeetcodeProblem {

    long maximumSumScore(int[] nums) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(s[i + 1], s[n] - s[i]));
        }
        return ans;
    }

}
