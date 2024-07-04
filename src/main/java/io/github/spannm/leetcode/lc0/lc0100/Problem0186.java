package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0186 extends LeetcodeProblem {

    void reverseWords(char[] _s) {

        reverse(_s, 0, _s.length - 1);

        int start = 0;
        for (int i = 0; i < _s.length; i++) {
            if (_s[i] == ' ') {
                reverse(_s, start, i - 1);
                start = i + 1;
            }
        }

        reverse(_s, start, _s.length - 1);
    }

    private void reverse(char[] _s, int _start, int _end) {
        while (_start < _end) {
            char temp = _s[_start];
            _s[_start++] = _s[_end];
            _s[_end--] = temp;
        }
    }

}
