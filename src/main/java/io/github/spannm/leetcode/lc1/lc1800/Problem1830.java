package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1830. Minimum Number of Operations to Make String Sorted.
 */
class Problem1830 extends LeetcodeProblem {

    private static final int    N   = 3010;
    private static final int    MOD = (int) 1e9 + 7;
    private static final long[] F   = new long[N];
    private static final long[] G   = new long[N];

    static {
        F[0] = 1;
        G[0] = 1;
        for (int i = 1; i < N; i++) {
            F[i] = F[i - 1] * i % MOD;
            G[i] = qmi(F[i], MOD - 2);
        }
    }

    static long qmi(long a, int k) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) == 1) {
                res = res * a % MOD;
            }
            k >>= 1;
            a = a * a % MOD;
        }
        return res;
    }

    int makeStringSorted(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            ++cnt[s.charAt(i) - 'a'];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int m = 0;
            for (int j = s.charAt(i) - 'a' - 1; j >= 0; j--) {
                m += cnt[j];
            }
            long t = m * F[n - i - 1] % MOD;
            for (int v : cnt) {
                t = t * G[v] % MOD;
            }
            --cnt[s.charAt(i) - 'a'];
            ans = (ans + t + MOD) % MOD;
        }
        return (int) ans;
    }

}
