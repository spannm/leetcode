package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1259. Handshakes That Don't Cross.
 */
class Problem1259 extends LeetcodeProblem {

    int numberOfWays(int _numPeople) {
        return dfs(_numPeople, new int[_numPeople + 1]);
    }

    static int dfs(int _i, int[] f) {
        if (_i < 2) {
            return 1;
        }
        if (f[_i] != 0) {
            return f[_i];
        }
        int mod = (int) 1e9 + 7;
        for (int l = 0; l < _i; l += 2) {
            int r = _i - l - 2;
            f[_i] = (int) ((f[_i] + 1L * dfs(l, f) * dfs(r, f) % mod) % mod);
        }
        return f[_i];
    }

}
