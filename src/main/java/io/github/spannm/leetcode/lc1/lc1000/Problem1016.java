package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1016. Binary String With Substrings Representing 1 To N.
 */
class Problem1016 extends LeetcodeProblem {

    boolean queryString(String _s, int _n) {
        if (_n > 1023) {
            return false;
        }
        for (int i = _n; i > _n / 2; i--) {
            if (!_s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

}
