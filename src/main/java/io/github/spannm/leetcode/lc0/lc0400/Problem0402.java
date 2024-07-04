package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0402 extends LeetcodeProblem {

    String removeKdigits(String _num, int _k) {
        int digits = _num.length() - _k;
        char[] stack = new char[_num.length()];
        int top = 0;

        for (int i = 0; i < _num.length(); i++) {
            char c = _num.charAt(i);
            while (top > 0 && stack[top - 1] > c && _k > 0) {
                top--;
                _k--;
            }
            stack[top++] = c;
        }

        int idx = 0;
        while (idx < digits && stack[idx] == '0') {
            idx++;
        }
        return idx == digits ? "0" : new String(stack, idx, digits - idx);
    }

}
