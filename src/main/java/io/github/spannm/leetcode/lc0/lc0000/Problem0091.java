package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0091 extends LeetcodeProblem {

    int numDecodings(String _s) {
        final int len = _s.length();
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = _s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= len; i++) {
            int first = Integer.parseInt(_s.substring(i - 1, i));
            int second = Integer.parseInt(_s.substring(i - 2, i));
            if (first > 0 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

}
