package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1049. Last Stone Weight II.
 */
class Problem1049 extends LeetcodeProblem {

    int lastStoneWeightII(int[] _stones) {
        int s = 0;
        for (int v : _stones) {
            s += v;
        }
        int n = s >> 1;
        int[] dp = new int[n + 1];
        for (int v : _stones) {
            for (int j = n; j >= v; j--) {
                dp[j] = Math.max(dp[j], dp[j - v] + v);
            }
        }
        return s - dp[n] * 2;
    }

}
