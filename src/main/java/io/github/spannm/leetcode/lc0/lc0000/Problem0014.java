package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">14. Longest Common Prefix</a>.
 */
class Problem0014 extends LeetcodeProblem {

    String longestCommonPrefix(String[] _arr) {
        if (_arr == null) {
            return "";
        }
        final int len = _arr.length;
        if (len <= 1) {
            return len == 0 ? "" : _arr[0];
        }

        for (int chrIdx = 0;; chrIdx++) {
            if (_arr[0].length() < chrIdx + 1) {
                return _arr[0].substring(0, chrIdx);
            }
            char prevChar = _arr[0].charAt(chrIdx);
            for (int strIdx = 1; strIdx < len; strIdx++) {
                if (_arr[strIdx].length() < chrIdx + 1) {
                    return _arr[0].substring(0, chrIdx);
                }
                char thisChar = _arr[strIdx].charAt(chrIdx);
                if (prevChar != thisChar) {
                    return _arr[0].substring(0, chrIdx);
                }
            }
        }
    }

}
