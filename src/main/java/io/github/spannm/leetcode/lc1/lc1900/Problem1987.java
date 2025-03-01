package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1987. Number of Unique Good Subsequences.
 */
class Problem1987 extends LeetcodeProblem {

    int numberOfUniqueGoodSubsequences(String binary) {
        final int mod = (int) 1e9 + 7;
        int f = 0;
        int g = 0;
        int ans = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                g = (g + f) % mod;
                ans = 1;
            } else {
                f = (f + g + 1) % mod;
            }
        }
        ans = (ans + f + g) % mod;
        return ans;
    }

}
