package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/add-digits/">258. Add Digits</a>.
 */
class Problem0258 extends LeetcodeProblem {

    int addDigits(int _num) {
        if (_num < 10) {
            return _num;
        }

        int sum = 0;
        while (_num > 0) {
            sum += _num % 10;
            _num = _num / 10;
        }

        return addDigits(sum);
    }

}
