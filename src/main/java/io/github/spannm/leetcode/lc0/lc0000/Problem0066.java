package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/plus-one/">66. Plus One</a>.
 */
class Problem0066 extends LeetcodeProblem {

    int[] plusOne(final int[] _digits) {
        final int len = _digits.length;
        _digits[len - 1] += 1;

        for (int i = len - 1; i >= 0; i--) {
            if (_digits[i] == 10 && i != 0) {
                _digits[i] = 0;
                _digits[i - 1] += 1;
            }
            if (_digits[i] == 10) {
                int[] copy = new int[len + 1];
                copy[i] = 1;
                return copy;
            }
        }
        return _digits;
    }

}
