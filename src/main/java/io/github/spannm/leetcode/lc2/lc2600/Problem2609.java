package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2609. Find the Longest Balanced Substring of a Binary String.
 */
class Problem2609 extends LeetcodeProblem {

    int findTheLongestBalancedSubstring(String s) {
        int zero = 0;
        int one = 0;
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (one > 0) {
                    zero = 0;
                    one = 0;
                }
                zero++;
            } else {
                ans = Math.max(ans, 2 * Math.min(zero, ++one));
            }
        }
        return ans;
    }

}
