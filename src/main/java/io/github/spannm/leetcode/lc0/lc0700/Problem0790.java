package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 790. Domino and Tromino Tiling.
 */
class Problem0790 extends LeetcodeProblem {

    int numTilings(int _n) {
        long[] f = {1, 0, 0, 0};
        int mod = (int) 1e9 + 7;
        for (int i = 1; i <= _n; i++) {
            long[] g = new long[4];
            g[0] = (f[0] + f[1] + f[2] + f[3]) % mod;
            g[1] = (f[2] + f[3]) % mod;
            g[2] = (f[1] + f[3]) % mod;
            g[3] = f[0];
            f = g;
        }
        return (int) f[0];
    }

}
