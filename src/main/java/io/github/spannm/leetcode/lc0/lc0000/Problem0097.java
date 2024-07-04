package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/interleaving-string/">97. Interleaving String</a>.
 */
class Problem0097 extends LeetcodeProblem {

    boolean isInterleave(final String _s1, final String _s2, final String _s3) {
        final int len1 = _s1.length();
        final int len2 = _s2.length();
        if (len1 + len2 != _s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[len1][len2] = true;

        for (int i1 = len1; i1 >= 0; i1--) {
            for (int i2 = len2; i2 >= 0; i2--) {
                if (i1 < len1 && _s1.charAt(i1) == _s3.charAt(i1 + i2) && dp[i1 + 1][i2]
                    || i2 < len2 && _s2.charAt(i2) == _s3.charAt(i1 + i2) && dp[i1][i2 + 1]) {
                    dp[i1][i2] = true;
                }
            }
        }

        return dp[0][0];
    }

}
