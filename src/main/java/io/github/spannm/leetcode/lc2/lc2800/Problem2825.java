package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2825. Make String a Subsequence Using Cyclic Increments.
 */
class Problem2825 extends LeetcodeProblem {

    boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int n = str2.length();
        for (char c : str1.toCharArray()) {
            char d = c == 'z' ? 'a' : (char) (c + 1);
            if (i < n && (str2.charAt(i) == c || str2.charAt(i) == d)) {
                i++;
            }
        }
        return i == n;
    }

}
