package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0405 extends LeetcodeProblem {

    String toHex(int _num) {
        char[] hexChars = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (_num != 0) {
            sb.insert(0, hexChars[_num & 15]);
            _num >>>= 4;
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

}
