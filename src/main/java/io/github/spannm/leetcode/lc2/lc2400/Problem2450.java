package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2450. Number of Distinct Binary Strings After Applying Operations.
 */
class Problem2450 extends LeetcodeProblem {

    static final int MOD = (int) 1e9 + 7;

    int countDistinctStrings(String s, int k) {
        int ans = 1;
        for (int i = 0; i < s.length() - k + 1; i++) {
            ans = ans * 2 % MOD;
        }
        return ans;
    }

}
