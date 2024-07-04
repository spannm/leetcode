package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2266. Count Number of Texts.
 */
class Problem2266 extends LeetcodeProblem {

    private static final int    N   = 100010;
    private static final int    MOD = (int) 1e9 + 7;
    private static final long[] F   = new long[N];
    private static final long[] G   = new long[N];
    static {
        F[0] = 1;
        F[1] = 1;
        F[2] = 2;
        F[3] = 4;
        G[0] = 1;
        G[1] = 1;
        G[2] = 2;
        G[3] = 4;
        for (int i = 4; i < N; i++) {
            F[i] = (F[i - 1] + F[i - 2] + F[i - 3]) % MOD;
            G[i] = (G[i - 1] + G[i - 2] + G[i - 3] + G[i - 4]) % MOD;
        }
    }

    int countTexts(String pressedKeys) {
        long ans = 1;
        for (int i = 0, n = pressedKeys.length(); i < n; i++) {
            int j = i;
            char c = pressedKeys.charAt(i);
            while (j + 1 < n && pressedKeys.charAt(j + 1) == c) {
                j++;
            }
            int cnt = j - i + 1;
            ans = c == '7' || c == '9' ? ans * G[cnt] : ans * F[cnt];
            ans %= MOD;
            i = j;
        }
        return (int) ans;
    }

}
