package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2457. Minimum Addition to Make Integer Beautiful.
 */
class Problem2457 extends LeetcodeProblem {

    long makeIntegerBeautiful(long n, int target) {
        long x = 0;
        while (f(n + x) > target) {
            long y = n + x;
            long p = 10;
            while (y % 10 == 0) {
                y /= 10;
                p *= 10;
            }
            x = (y / 10 + 1) * p - n;
        }
        return x;
    }

    private int f(long x) {
        int y = 0;
        while (x > 0) {
            y += x % 10;
            x /= 10;
        }
        return y;
    }

}
