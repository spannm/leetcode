package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2930. Number of Strings Which Can Be Rearranged to Contain Substring.
 */
class Problem2930 extends LeetcodeProblem {

    private final int mod = (int) 1e9 + 7;

    int stringCount(int n) {
        long a = qpow(25, n);
        long b = a;
        long c = (qpow(25, n) + n * qpow(25, n - 1) % mod) % mod;
        long ab = qpow(24, n);
        long ac = (qpow(24, n) + n * qpow(24, n - 1) % mod) % mod;
        long bc = ac;
        long abc = (qpow(23, n) + n * qpow(23, n - 1) % mod) % mod;
        long tot = qpow(26, n);
        return (int) ((tot - (a + b + c - ab - ac - bc + abc)) % mod + mod) % mod;
    }

    private long qpow(long a, int n) {
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
