package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1957 extends LeetcodeProblem {

    String makeFancyString(String _s) {
        StringBuilder sb = new StringBuilder();
        int freq = 0;
        for (int i = 0; i < _s.length(); i++) {
            if (i > 0) {
                if (_s.charAt(i) == _s.charAt(i - 1)) {
                    freq++;
                } else {
                    freq = 1;
                }
            } else {
                freq = 1;
                sb.append(_s.charAt(i));
            }
            if (freq <= 2) {
                sb.append(_s.charAt(i));
            }
        }
        return sb.toString();
    }

}
