package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2520 extends LeetcodeProblem {

    int countDigits(int _num) {
        int original = _num;
        int sum = 0;
        while (_num != 0) {
            int digit = _num % 10;
            _num /= 10;
            if (original % digit == 0) {
                sum++;
            }
        }
        return sum;
    }

}
