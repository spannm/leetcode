package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1682. Longest Palindromic Subsequence II.
 */
class Problem1682 extends LeetcodeProblem {

    private int[][][] f;
    private String    s;

    int longestPalindromeSubseq(String _s) {
        s = _s;
        int len = _s.length();
        f = new int[len][len][27];
        for (var a : f) {
            for (var b : a) {
                Arrays.fill(b, -1);
            }
        }
        return dfs(0, len - 1, 26);
    }

    private int dfs(int i, int j, int x) {
        if (i >= j) {
            return 0;
        }
        if (f[i][j][x] != -1) {
            return f[i][j][x];
        }
        int ans = 0;
        if (s.charAt(i) == s.charAt(j) && s.charAt(i) - 'a' != x) {
            ans = dfs(i + 1, j - 1, s.charAt(i) - 'a') + 2;
        } else {
            ans = Math.max(dfs(i + 1, j, x), dfs(i, j - 1, x));
        }
        f[i][j][x] = ans;
        return ans;
    }

}
