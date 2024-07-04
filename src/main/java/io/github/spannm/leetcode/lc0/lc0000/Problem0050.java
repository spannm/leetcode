package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/powx-n/">50. Pow(x, n)</a>.
 */
class Problem0050 extends LeetcodeProblem {

    double myPow(double _x, int _n) {
        if (_n == 0) {
            return 1.0;
        } else if (_n == Integer.MIN_VALUE) {
            _x = _x * _x;
            _n = _n / 2;
        }

        if (_n < 0) {
            _x = 1 / _x;
            _n = -_n;
        }

        double result = 1.0;
        while (_n > 0) {
            if (_n % 2 == 1) {
                result *= _x;
            }

            _x *= _x;
            _n /= 2;
        }

        return result;
    }

}
