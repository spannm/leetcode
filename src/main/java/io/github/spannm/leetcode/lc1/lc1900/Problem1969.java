package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1969. Minimum Non-Zero Product of the Array Elements.
 */
class Problem1969 extends LeetcodeProblem {

    int minNonZeroProduct(int p) {
        final int mod = (int) 1e9 + 7;
        long a = ((1L << p) - 1) % mod;
        long b = qpow(((1L << p) - 2) % mod, (1L << p - 1) - 1, mod);
        return (int) (a * b % mod);
    }

    private long qpow(long a, long n, int mod) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return ans;
    }

}
