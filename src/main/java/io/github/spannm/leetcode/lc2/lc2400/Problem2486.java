package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2486. Append Characters to String to Make Subsequence.
 */
class Problem2486 extends LeetcodeProblem {

    int appendCharacters(String _s1, String _s2) {
        int len1 = _s1.length();
        int len2 = _s2.length();
        for (int i = 0, j = 0; j < len2; j++) {
            while (i < len1 && _s1.charAt(i) != _s2.charAt(j)) {
                i++;
            }
            if (i++ == len1) {
                return len2 - j;
            }
        }
        return 0;
    }

}
