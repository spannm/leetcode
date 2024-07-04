package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0647 extends LeetcodeProblem {

    int countSubstrings(String _s) {
        int len = _s.length();
        if (len <= 1) {
            return len;
        }
        char[] chars = _s.toCharArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += extendPalindrome(chars, len, i, i);
            count += extendPalindrome(chars, len, i, i + 1);
        }
        return count;
    }

    static int extendPalindrome(char[] _chars, int _len, int _left, int _right) {
        int count = 0;
        while (_left >= 0 && _right < _len && _chars[_left] == _chars[_right]) {
            count++;
            _left--;
            _right++;
        }
        return count;
    }

}
