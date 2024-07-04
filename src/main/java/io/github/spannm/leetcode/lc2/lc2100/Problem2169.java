package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2169 extends LeetcodeProblem {

    int countOperations(int _num1, int _num2) {
        int ops = 0;
        while (true) {
            if (_num1 == 0 || _num2 == 0) {
                return ops;
            } else if (_num1 >= _num2) {
                _num1 -= _num2;
            } else {
                _num2 -= _num1;
            }
            ops++;

        }
    }

}
