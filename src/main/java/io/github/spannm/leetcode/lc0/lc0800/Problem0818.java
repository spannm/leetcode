package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 818. Race Car.
 */
class Problem0818 extends LeetcodeProblem {

    int racecar(int _target) {
        int[] dp = new int[_target + 1];
        for (int i = 1; i <= _target; i++) {
            int k = 32 - Integer.numberOfLeadingZeros(i);
            if (i == (1 << k) - 1) {
                dp[i] = k;
                continue;
            }
            dp[i] = dp[(1 << k) - 1 - i] + k + 1;
            for (int j = 0; j < k; j++) {
                dp[i] = Math.min(dp[i], dp[i - (1 << k - 1) + (1 << j)] + k - 1 + j + 2);
            }
        }
        return dp[_target];
    }

}
