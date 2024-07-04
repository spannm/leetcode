package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1047 extends LeetcodeProblem {

    String removeDuplicates(String _s) {
        String sb = _s;
        for (int i = 0; i < _s.length() - 1; i++) {
            if (_s.charAt(i) == _s.charAt(i + 1)) {
                return removeDuplicates(_s.substring(0, i) + _s.substring(i + 2));
            }
        }
        return sb;
    }

}
