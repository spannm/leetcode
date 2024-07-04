package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/divide-two-integers/">29. Divide Two Integers</a>.
 */
class Problem0029 extends LeetcodeProblem {

    int divide(int _dividend, int _divisor) {
        if (_dividend == Integer.MIN_VALUE && _divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negCount = 0;
        if (_dividend < 0) {
            negCount++;
        } else {
            _dividend = -_dividend;
        }
        if (_divisor < 0) {
            negCount++;
        } else {
            _divisor = -_divisor;
        }

        int quotient = 0;
        final int halfIntMin = Integer.MIN_VALUE / 2;

        while (_dividend <= _divisor) {
            int powerOfTwo = -1;
            int value = _divisor;
            while (value >= halfIntMin && value + value >= _dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            quotient += powerOfTwo;
            _dividend -= value;
        }
        if (negCount != 1) {
            quotient = -quotient;
        }
        return quotient;
    }

}
