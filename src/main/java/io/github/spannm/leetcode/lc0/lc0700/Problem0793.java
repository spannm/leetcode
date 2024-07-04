package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 793. Preimage Size of Factorial Zeroes Function.
 */
class Problem0793 extends LeetcodeProblem {

    int preimageSizeFZF(int _k) {
        return g(_k + 1) - g(_k);
    }

    private int g(int _k) {
        long left = 0;
        long right = 5 * _k;
        while (left < right) {
            long mid = left + right >> 1;
            if (f(mid) >= _k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private int f(long _x) {
        if (_x == 0) {
            return 0;
        }
        return (int) (_x / 5) + f(_x / 5);
    }

}
