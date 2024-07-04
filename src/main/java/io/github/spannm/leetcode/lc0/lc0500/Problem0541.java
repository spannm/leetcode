package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0541 extends LeetcodeProblem {

    String reverseStr(String _s, int _k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _s.length(); i = i + 2 * _k) {
            if (_s.length() >= i + _k) {
                sb.append(new StringBuilder(_s.substring(i, i + _k)).reverse());
            } else {
                sb.append(new StringBuilder(_s.substring(i)).reverse());
                break;
            }
            if (i + 2 * _k <= _s.length()) {
                sb.append(_s, i + _k, i + 2 * _k);
            } else {
                sb.append(_s.substring(i + _k));
            }
        }
        return sb.toString();
    }

}
