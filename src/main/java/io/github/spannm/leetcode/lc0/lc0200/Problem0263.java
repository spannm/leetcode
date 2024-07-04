package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0263 extends LeetcodeProblem {

    boolean isUgly(int _num) {
        if (_num == 0) {
            return false;
        }
        int[] divisors = new int[] {5, 3, 2};
        for (int divisor : divisors) {
            while (_num % divisor == 0) {
                _num /= divisor;
            }
        }
        return _num == 1;
    }

}
