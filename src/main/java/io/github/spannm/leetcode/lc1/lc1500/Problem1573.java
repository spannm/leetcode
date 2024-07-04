package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1573. Number of Ways to Split a String.
 */
class Problem1573 extends LeetcodeProblem {

    private String s;

    int numWays(String _s) {
        s = _s;
        int cnt = 0;
        int n = _s.length();
        for (int i = 0; i < n; i++) {
            if (_s.charAt(i) == '1') {
                cnt++;
            }
        }
        int m = cnt % 3;
        if (m != 0) {
            return 0;
        }
        final int mod = (int) 1e9 + 7;
        if (cnt == 0) {
            return (int) ((n - 1L) * (n - 2) / 2 % mod);
        }
        cnt /= 3;
        long i1 = find(cnt);
        long i2 = find(cnt + 1);
        long j1 = find(cnt * 2);
        long j2 = find(cnt * 2 + 1);
        return (int) ((i2 - i1) * (j2 - j1) % mod);
    }

    private int find(int x) {
        int t = 0;
        for (int i = 0;; i++) {
            t += s.charAt(i) == '1' ? 1 : 0;
            if (t == x) {
                return i;
            }
        }
    }

}
