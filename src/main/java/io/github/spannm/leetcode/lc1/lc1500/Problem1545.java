package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1545 extends LeetcodeProblem {

    char findKthBit(int _n, int _k) {
        String[] strings = new String[_n];
        strings[0] = "0";
        for (int i = 1; i < _n; i++) {
            strings[i] = formString(strings[i - 1]);
        }
        return strings[_n - 1].charAt(_k - 1);
    }

    private String formString(String _str) {
        return _str + "1" + reverse(invert(_str));
    }

    private String reverse(String _str) {
        StringBuilder sb = new StringBuilder();
        return sb.append(_str).reverse().toString();
    }

    private String invert(String _str) {
        StringBuilder sb = new StringBuilder();
        for (char c : _str.toCharArray()) {
            if (c == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return sb.toString();
    }

}
