package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/factorial-trailing-zeroes/">172. Factorial Trailing Zeroes</a>.
 */
class Problem0172 extends LeetcodeProblem {

    int trailingZeroes(int _n) {
        int result = 0;
        while (_n > 4) {
            _n /= 5;
            result += _n;
        }
        return result;
    }

}
