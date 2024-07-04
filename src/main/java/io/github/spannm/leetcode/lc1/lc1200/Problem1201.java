package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1201. Ugly Number III.
 */
class Problem1201 extends LeetcodeProblem {

    int nthUglyNumber(int _n, int _a, int _b, int _c) {
        long ab = lcm(_a, _b);
        long bc = lcm(_b, _c);
        long ac = lcm(_a, _c);
        long abc = lcm(ab, _c);
        long l = 1;
        long r = 2000000000;
        while (l < r) {
            long mid = l + r >> 1;
            if (mid / _a + mid / _b + mid / _c - mid / ab - mid / bc - mid / ac + mid / abc >= _n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private long gcd(long _a, long _b) {
        return _b == 0 ? _a : gcd(_b, _a % _b);
    }

    private long lcm(long _a, long _b) {
        return _a * _b / gcd(_a, _b);
    }

}
