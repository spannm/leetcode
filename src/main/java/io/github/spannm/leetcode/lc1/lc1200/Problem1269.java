package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/">1269. Number of
 * Ways to Stay in the Same Place After Some Steps</a>.
 */
class Problem1269 extends LeetcodeProblem {

    int numWays(int _steps, int _arrLen) {
        int n = Math.min(_steps / 2 + 1, _arrLen);
        int[] curr = new int[n];
        int[] prev = new int[n];
        curr[0] = 1;
        prev[0] = 1;
        final int mod = 1000000007;

        for (int i1 = 1; i1 <= _steps; i1++) {
            for (int i2 = 0; i2 < n; i2++) {
                curr[i2] = prev[i2];
                if (i2 > 0) {
                    curr[i2] = (curr[i2] + prev[i2 - 1]) % mod;
                }
                if (i2 < n - 1) {
                    curr[i2] = (curr[i2] + prev[i2 + 1]) % mod;
                }
            }
            prev = curr.clone();
        }
        return curr[0];
    }

}
