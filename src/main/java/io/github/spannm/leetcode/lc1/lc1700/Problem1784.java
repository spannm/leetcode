package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1784 extends LeetcodeProblem {

    boolean checkOnesSegment(String _s) {
        boolean metOne = false;
        for (int i = 0; i < _s.length(); i++) {
            if ('1' == _s.charAt(i) && metOne) {
                return false;
            } else if ('1' == _s.charAt(i)) {
                metOne = true;
                while (i < _s.length() && '1' == _s.charAt(i)) {
                    i++;
                }
            }
        }
        return true;
    }

}
