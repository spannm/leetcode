package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2124 extends LeetcodeProblem {

    boolean checkString(String _s) {
        int aIndex = _s.lastIndexOf('a');
        if (aIndex < 0) {
            return true;
        }
        for (int i = 0; i < aIndex; i++) {
            if (_s.charAt(i) == 'b') {
                return false;
            }
        }
        return true;
    }

}
