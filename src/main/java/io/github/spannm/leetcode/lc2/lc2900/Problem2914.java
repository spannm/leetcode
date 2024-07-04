package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2914. Minimum Number of Changes to Make Binary String Beautiful.
 */
class Problem2914 extends LeetcodeProblem {

    int minChanges(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans++;
            }
        }
        return ans;
    }

}
