package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/max-dot-product-of-two-subsequences/">1458. Max Dot Product of Two
 * Subsequences</a>.
 */
class Problem1458 extends LeetcodeProblem {

    static int maxDotProduct(int[] _nums1, int[] _nums2) {
        final int len1 = _nums1.length;
        final int len2 = _nums2.length;

        if (len1 < len2) {
            return maxDotProduct(_nums2, _nums1);
        }

        long[] dp = new long[len2 + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int i : _nums1) {
            long prev = 0;
            for (int i2 = 0; i2 < len2; i2++) {
                long temp = dp[i2 + 1];
                dp[i2 + 1] = Math.max(prev + i * _nums2[i2], Math.max(i * _nums2[i2], Math.max(dp[i2], dp[i2 + 1])));
                prev = temp;
            }
        }

        int result = (int) dp[len2];

        _nums1 = null;
        _nums2 = null;
        dp = null;

        return result;
    }

}
