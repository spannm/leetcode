package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2000 extends LeetcodeProblem {

    String reversePrefix(String _word, char _ch) {
        int end = _word.length();
        for (int i = 0; i < _word.length(); i++) {
            if (_word.charAt(i) == _ch) {
                end = i;
                break;
            }
        }
        if (end == _word.length()) {
            return _word;
        }
        StringBuilder sb = new StringBuilder(_word.substring(0, end + 1));
        sb.reverse();
        sb.append(_word.substring(end + 1));
        return sb.toString();
    }

}
