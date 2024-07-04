package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2550. Count Collisions of Monkeys on a Polygon.
 */
class Problem2550 extends LeetcodeProblem {

    int monkeyMove(int n) {
        final int mod = (int) 1e9 + 7;
        return (qpow(2, n, mod) - 2 + mod) % mod;
    }

    private int qpow(long a, int n, int mod) {
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
