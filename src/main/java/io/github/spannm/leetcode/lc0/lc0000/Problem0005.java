package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a>.
 */
class Problem0005 extends LeetcodeProblem {

    String longestPalindrome(final String _s) {
        final int slen = _s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < slen; i++) {
            int len1 = expand(_s, slen, i, i);
            int len2 = expand(_s, slen, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return _s.substring(start, end + 1);
    }

    static int expand(final String _s, final int _slen, int _left, int _right) {
        while (_left >= 0 && _right < _slen && _s.charAt(_left) == _s.charAt(_right)) {
            _left--;
            _right++;
        }
        return _right - _left - 1;
    }

}
