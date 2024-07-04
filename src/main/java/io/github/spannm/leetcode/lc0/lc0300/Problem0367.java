package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0367 extends LeetcodeProblem {

    boolean isPerfectSquare(int _num) {
        long i = 1;
        long tmp = 1;
        while (tmp < _num) {
            i += 2;
            tmp += i;
        }
        return tmp == _num;
    }

}
