package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1513. Number of Substrings With Only 1s.
 */
class Problem1513 extends LeetcodeProblem {

    int numSub(String s) {
        final int mod = (int) 1e9 + 7;
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt = s.charAt(i) == '1' ? cnt + 1 : 0;
            ans = (ans + cnt) % mod;
        }
        return ans;
    }

}
