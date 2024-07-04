package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/count-vowels-permutation/">1220. Count Vowels Permutation</a>.
 */
class Problem1220 extends LeetcodeProblem {

    int countVowelPermutation(int _n) {
        int mod = 1000_000_007;
        long ca = 1;
        long ce = 1;
        long ci = 1;
        long co = 1;
        long cu = 1;
        long a;
        long e;
        long i;
        long o;
        long u;

        while (--_n > 0) {
            a = (ce + ci + cu) % mod;
            e = (ca + ci) % mod;
            i = (ce + co) % mod;
            o = ci;
            u = (ci + co) % mod;

            ca = a;
            ce = e;
            ci = i;
            co = o;
            cu = u;
        }

        return (int) ((ca + ce + ci + co + cu) % mod);
    }

}
