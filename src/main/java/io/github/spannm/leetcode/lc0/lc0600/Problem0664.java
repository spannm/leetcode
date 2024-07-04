package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/strange-printer/description/">664. Strange Printer</a>.
 */
class Problem0664 extends LeetcodeProblem {

    int strangePrinter(final String _s) {
        final int len = _s.length();
        if (len == 1) {
            return 1;
        }
        char[] chars = _s.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len && l + i - 1 < len; i++) {
                int j = l + i - 1;
                dp[i][j] = dp[i][j - 1] + (chars[i] == chars[j] ? 0 : 1);
                for (int k = i + 1; k < j; k++) {
                    if (chars[k] == chars[j]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k][j - 1]);
                    }
                }
            }
        }
        int result = dp[0][len - 1];

        chars = null;
        dp = null;
        System.gc();

        return result;
    }

}
