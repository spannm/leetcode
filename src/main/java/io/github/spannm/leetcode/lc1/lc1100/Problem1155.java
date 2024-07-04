package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1155. Number of Dice Rolls With Target Sum.
 */
class Problem1155 extends LeetcodeProblem {

    int numRollsToTarget(int _n, int _k, int _target) {
        final int mod = (int) 1e9 + 7;
        int[] f = new int[_target + 1];
        f[0] = 1;
        for (int i = 1; i <= _n; i++) {
            int[] g = new int[_target + 1];
            for (int j = 1; j <= Math.min(_target, i * _k); j++) {
                for (int h = 1; h <= Math.min(j, _k); h++) {
                    g[j] = (g[j] + f[j - h]) % mod;
                }
            }
            f = g;
        }
        return f[_target];
    }

}
