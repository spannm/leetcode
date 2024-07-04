package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0650 extends LeetcodeProblem {

    int minSteps(int _n) {
        int[] dp = new int[_n + 1];
        for (int i = 2; i <= _n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[_n];
    }

}
