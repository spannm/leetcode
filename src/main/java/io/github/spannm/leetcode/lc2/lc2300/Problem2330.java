package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2330. Valid Palindrome IV.
 */
class Problem2330 extends LeetcodeProblem {

    boolean makePalindrome(String s) {
        int cnt = 0;
        int i = 0;
        int j = s.length() - 1;
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                cnt++;
            }
        }
        return cnt <= 2;
    }

}
