package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1866. Number of Ways to Rearrange Sticks With K Sticks Visible.
 */
class Problem1866 extends LeetcodeProblem {

    int rearrangeSticks(int n, int k) {
        final int mod = (int) 1e9 + 7;
        int[] f = new int[k + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = k; j > 0; j--) {
                f[j] = (int) ((f[j] * (i - 1L) + f[j - 1]) % mod);
            }
            f[0] = 0;
        }
        return f[k];
    }

}
