package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 878. Nth Magical Number.
 */
class Problem0878 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int nthMagicalNumber(int _n, int _a, int _b) {
        int c = _a * _b / gcd(_a, _b);
        long l = 0;
        long r = (long) (_a + _b) * _n;
        while (l < r) {
            long mid = l + r >>> 1;
            if (mid / _a + mid / _b - mid / c >= _n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) (l % MOD);
    }

    static int gcd(int _a, int _b) {
        return _b == 0 ? _a : gcd(_b, _a % _b);
    }

}
