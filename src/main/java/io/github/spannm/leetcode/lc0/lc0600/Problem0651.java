package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0651 extends LeetcodeProblem {

    int maxA(int _n) {
        int[] dp = new int[_n + 1];
        for (int i = 1; i <= _n; i++) {
            dp[i] = i;
            for (int j = 3; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }
        return dp[_n];
    }

}
