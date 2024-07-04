package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1808. Maximize Number of Nice Divisors.
 */
class Problem1808 extends LeetcodeProblem {

    private final int mod = (int) 1e9 + 7;

    int maxNiceDivisors(int primeFactors) {
        if (primeFactors < 4) {
            return primeFactors;
        }
        if (primeFactors % 3 == 0) {
            return qpow(3, primeFactors / 3);
        }
        if (primeFactors % 3 == 1) {
            return (int) (4L * qpow(3, primeFactors / 3 - 1) % mod);
        }
        return 2 * qpow(3, primeFactors / 3) % mod;
    }

    private int qpow(long a, long n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return (int) ans;
    }

}
