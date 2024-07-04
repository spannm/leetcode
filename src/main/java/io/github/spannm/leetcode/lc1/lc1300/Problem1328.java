package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1328. Break a Palindrome.
 */
class Problem1328 extends LeetcodeProblem {

    String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        char[] cs = palindrome.toCharArray();
        int i = 0;
        while (i < n / 2 && cs[i] == 'a') {
            i++;
        }
        if (i == n / 2) {
            cs[n - 1] = 'b';
        } else {
            cs[i] = 'a';
        }
        return String.valueOf(cs);
    }

}
