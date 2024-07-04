package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2484. Count Palindromic Subsequences.
 */
class Problem2484 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int countPalindromes(String s) {
        int n = s.length();
        int[][][] pre = new int[n + 2][10][10];
        int[][][] suf = new int[n + 2][10][10];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = s.charAt(i) - '0';
        }
        int[] c = new int[10];
        for (int i = 1; i <= n; i++) {
            int v = t[i - 1];
            for (int j = 0; j < 10; j++) {
                System.arraycopy(pre[i - 1][j], 0, pre[i][j], 0, 10);
            }
            for (int j = 0; j < 10; j++) {
                pre[i][j][v] += c[j];
            }
            c[v]++;
        }
        c = new int[10];
        for (int i = n; i > 0; i--) {
            int v = t[i - 1];
            for (int j = 0; j < 10; j++) {
                System.arraycopy(suf[i + 1][j], 0, suf[i][j], 0, 10);
            }
            for (int j = 0; j < 10; j++) {
                suf[i][j][v] += c[j];
            }
            c[v]++;
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    ans += (long) pre[i - 1][j][k] * suf[i + 1][j][k];
                    ans %= MOD;
                }
            }
        }
        return (int) ans;
    }

}
