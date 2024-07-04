package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0507 extends LeetcodeProblem {

    boolean checkPerfectNumber(int _num) {
        if (_num == 1) {
            return false;
        }
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(_num); i++) {
            if (_num % i == 0) {
                sum += i;
                if (i != _num / i) {
                    sum += _num / i;
                }
            }
        }
        sum++;
        return sum == _num;
    }

}
