package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/integer-break/">343. Integer Break</a>.
 */
class Problem0343 extends LeetcodeProblem {

    int integerBreak(int _n) {
        if (_n == 2) {
            return 1;
        } else if (_n == 3) {
            return 2;
        } else if (_n % 3 == 0) {
            return (int) Math.pow(3, _n / 3);
        } else if (_n % 3 == 1) {
            return 2 * 2 * (int) Math.pow(3, (_n - 4) / 3);
        } else {
            return 2 * (int) Math.pow(3, _n / 3);
        }
    }

}
