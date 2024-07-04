package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2414. Length of the Longest Alphabetical Continuous Substring.
 */
class Problem2414 extends LeetcodeProblem {

    int longestContinuousSubstring(String s) {
        int ans = 0;
        int i = 0;
        int j = 1;
        for (; j < s.length(); j++) {
            ans = Math.max(ans, j - i);
            if (s.charAt(j) - s.charAt(j - 1) != 1) {
                i = j;
            }
        }
        ans = Math.max(ans, j - i);
        return ans;
    }

}
