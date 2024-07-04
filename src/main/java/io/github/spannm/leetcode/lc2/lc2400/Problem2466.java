package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/count-ways-to-build-good-strings/">2466. Count Ways To Build Good Strings</a>.
 */
class Problem2466 extends LeetcodeProblem {

    static int countGoodStrings(int _min, int _max, int _nbZero, int _nbOne) {
        int mod = 1000000007;
        int[] dp = new int[_max + 1];
        dp[0] = 1;
        int result = 0;
        for (int i = 1; i <= _max; i++) {
            int dpi = 0;
            if (i - _nbZero >= 0) {
                dpi = dp[i - _nbZero];
            }

            if (i - _nbOne >= 0) {
                dpi += dp[i - _nbOne];
            }
            dp[i] = dpi % mod;
            if (i >= _min) {
                result = (result + dp[i]) % mod;
            }
        }
        return result;
    }

}
