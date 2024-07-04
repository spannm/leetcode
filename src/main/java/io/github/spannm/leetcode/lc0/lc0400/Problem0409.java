package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0409 extends LeetcodeProblem {

    int longestPalindrome(String _s) {
        int[] counts = new int[56];
        _s.chars().map(c -> Character.isUpperCase(c) ? c - 'A' + 33 : c - 'a').forEach(i -> counts[i]++);
        boolean hasOdd = false;
        int len = 0;
        for (int i = 0; i < 56; i++) {
            if (counts[i] % 2 != 0) {
                hasOdd = true;
                if (counts[i] > 1) {
                    len += counts[i] - 1;
                }
            } else {
                len += counts[i];
            }
        }
        return hasOdd ? len + 1 : len;
    }

}
