package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2697. Lexicographically Smallest Palindrome.
 */
class Problem2697 extends LeetcodeProblem {

    String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; i++, j--) {
            cs[i] = cs[j] = (char) Math.min(cs[i], cs[j]);
        }
        return new String(cs);
    }

}
