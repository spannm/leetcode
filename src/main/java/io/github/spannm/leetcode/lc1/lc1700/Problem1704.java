package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/determine-if-string-halves-are-alike/">1704. Determine if String Halves Are
 * Alike</a>.
 */
class Problem1704 extends LeetcodeProblem {

    boolean halvesAreAlike(final String _str) {
        final int len = _str.length();
        final int half = len / 2;

        final char[] arr = _str.toCharArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'
                || arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U') {
                if (i < half) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count == 0;
    }

}
