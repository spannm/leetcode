package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0326 extends LeetcodeProblem {

    boolean isPowerOfThree(int _n) {
        if (_n < 3 && _n != 1) {
            return false;
        }
        while (_n != 1) {
            if (_n % 3 != 0) {
                return false;
            }
            _n /= 3;
        }
        return true;
    }

}
