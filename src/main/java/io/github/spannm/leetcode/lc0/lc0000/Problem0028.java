package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">28. Find the Index of the
 * First Occurrence in a String</a>.
 */
class Problem0028 extends LeetcodeProblem {

    int strStr(String _haystack, String _needle) {
        final int needleLen = _needle.length();
        final int haystackLen = _haystack.length();
        if (needleLen > haystackLen) {
            return -1;
        }
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needleLen) {
                    return i;
                } else if (i + j == haystackLen) {
                    return -1;
                } else if (_needle.charAt(j) != _haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }

}
