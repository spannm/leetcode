package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2036. Maximum Alternating Subarray Sum.
 */
class Problem2036 extends LeetcodeProblem {

    long maximumAlternatingSubarraySum(int[] nums) {
        final long inf = 1L << 60;
        long ans = -inf;
        long f = -inf;
        long g = -inf;
        for (int x : nums) {
            long ff = Math.max(g, 0) + x;
            g = f - x;
            f = ff;
            ans = Math.max(ans, Math.max(f, g));
        }
        return ans;
    }

}
