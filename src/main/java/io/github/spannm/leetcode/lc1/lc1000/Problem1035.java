package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/uncrossed-lines/">1035. Uncrossed Lines</a>.
 */
class Problem1035 extends LeetcodeProblem {

    static int maxUncrossedLines(int[] _nums1, int[] _nums2) {
        final int len1 = _nums1.length;
        final int len2 = _nums2.length;
        final int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i1 = 0; i1 < len1; i1++) {
            for (int i2 = 0; i2 < len2; i2++) {
                if (_nums1[i1] == _nums2[i2]) {
                    dp[i1 + 1][i2 + 1] = dp[i1][i2] + 1;
                } else {
                    dp[i1 + 1][i2 + 1] = Math.max(dp[i1][i2 + 1], dp[i1 + 1][i2]);
                }
            }
        }
        return dp[len1][len2];
    }

}
