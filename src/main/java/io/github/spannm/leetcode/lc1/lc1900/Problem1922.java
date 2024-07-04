package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1922. Count Good Numbers.
 */
class Problem1922 extends LeetcodeProblem {

    private static final int MOD = 1000000007;

    int countGoodNumbers(long n) {
        return (int) (myPow(5, n + 1 >> 1) * myPow(4, n >> 1) % MOD);
    }

    private long myPow(long x, long n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }

}
