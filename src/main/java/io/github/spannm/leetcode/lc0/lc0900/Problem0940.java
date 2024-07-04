package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 940. Distinct Subsequences II.
 */
class Problem0940 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int distinctSubseqII(String _s) {
        int[] dp = new int[26];
        int ans = 0;
        for (int i = 0; i < _s.length(); i++) {
            int j = _s.charAt(i) - 'a';
            int add = (ans - dp[j] + 1) % MOD;
            ans = (ans + add) % MOD;
            dp[j] = (dp[j] + add) % MOD;
        }
        return (ans + MOD) % MOD;
    }

}
