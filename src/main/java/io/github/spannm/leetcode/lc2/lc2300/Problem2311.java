package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2311. Longest Binary Subsequence Less Than or Equal to K.
 */
class Problem2311 extends LeetcodeProblem {

    int longestSubsequence(String s, int k) {
        int ans = 0;
        int v = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ans++;
            } else if (ans < 30 && (v | 1 << ans) <= k) {
                v |= 1 << ans;
                ans++;
            }
        }
        return ans;
    }

}
