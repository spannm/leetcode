package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/restore-the-array/">1416. Restore The Array</a>.
 */
class Problem1416 extends LeetcodeProblem {

    static int numberOfArrays(String _str, int _range) {
        final int len = _str.length();
        final char[] astr = _str.toCharArray();

        final int mod = (int) 1e9 + 7;

        final int[] dp = new int[len + 1];
        dp[len] = 1;

        for (int i = len - 1; i >= 0; i--) {
            long num = 0;
            long sum = 0;
            for (int j = i; j < len; j++) {
                num = num * 10 + (astr[j] - '0');
                if (num == 0 || num > _range) {
                    break;
                }
                sum += dp[j + 1];
            }
            dp[i] = (int) (sum % mod);
        }
        return dp[0];
    }

}
