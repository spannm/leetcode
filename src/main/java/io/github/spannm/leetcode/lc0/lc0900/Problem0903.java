package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 903. Valid Permutations for DI Sequence.
 */
class Problem0903 extends LeetcodeProblem {

    int numPermsDISequence(String _s) {
        final int mod = (int) 1e9 + 7;
        int n = _s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int pre = 0;
            int[] g = new int[n + 1];
            if (_s.charAt(i - 1) == 'D') {
                for (int j = i; j >= 0; j--) {
                    pre = (pre + f[j]) % mod;
                    g[j] = pre;
                }
            } else {
                for (int j = 0; j <= i; j++) {
                    g[j] = pre;
                    pre = (pre + f[j]) % mod;
                }
            }
            f = g;
        }
        int ans = 0;
        for (int j = 0; j <= n; j++) {
            ans = (ans + f[j]) % mod;
        }
        return ans;
    }

}
