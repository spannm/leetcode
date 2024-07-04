package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/">242. Valid Anagram</a>.
 */
class Problem0242 extends LeetcodeProblem {

    boolean isAnagram(String _s, String _t) {
        final int len = _s.length();
        if (len != _t.length()) {
            return false;
        }
        final char[] arrs = _s.toCharArray();
        java.util.Arrays.sort(arrs);
        final char[] arrt = _t.toCharArray();
        java.util.Arrays.sort(arrt);

        for (int i = 0; i < len; i++) {
            if (arrs[i] != arrt[i]) {
                return false;
            }
        }

        return true;
    }

}
