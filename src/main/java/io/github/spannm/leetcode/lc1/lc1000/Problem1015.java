package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1015. Smallest Integer Divisible by K.
 */
class Problem1015 extends LeetcodeProblem {

    int smallestRepunitDivByK(int _k) {
        int n = 1 % _k;
        for (int i = 1; i <= _k; i++) {
            if (n == 0) {
                return i;
            }
            n = (n * 10 + 1) % _k;
        }
        return -1;
    }

}
