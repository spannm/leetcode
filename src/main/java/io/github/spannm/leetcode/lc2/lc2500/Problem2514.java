package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.math.BigInteger;

/**
 * 2514. Count Anagrams.
 */
class Problem2514 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int countAnagrams(String s) {
        int n = s.length();
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] * i % MOD;
        }
        long p = 1;
        for (String w : s.split(" ")) {
            int[] cnt = new int[26];
            for (int i = 0; i < w.length(); i++) {
                ++cnt[w.charAt(i) - 'a'];
            }
            p = p * f[w.length()] % MOD;
            for (int v : cnt) {
                p = p * BigInteger.valueOf(f[v]).modInverse(BigInteger.valueOf(MOD)).intValue()
                    % MOD;
            }
        }
        return (int) p;
    }

}
