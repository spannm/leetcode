package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2749. Minimum Operations to Make the Integer Zero.
 */
class Problem2749 extends LeetcodeProblem {

    int makeTheIntegerZero(int num1, int num2) {
        for (long k = 1;; k++) {
            long x = num1 - k * num2;
            if (x < 0) {
                break;
            }
            if (Long.bitCount(x) <= k && k <= x) {
                return (int) k;
            }
        }
        return -1;
    }

}
