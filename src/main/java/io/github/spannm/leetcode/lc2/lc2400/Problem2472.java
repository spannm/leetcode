package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2472. Maximum Number of Non-overlapping Palindrome Substrings.
 */
class Problem2472 extends LeetcodeProblem {

    private boolean[][] dp;
    private int[]       f;
    private int         n;
    private int         k;

    int maxPalindromes(String _s, int _k) {
        n = _s.length();
        f = new int[n];
        k = _k;
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
            f[i] = -1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = _s.charAt(i) == _s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != -1) {
            return f[i];
        }
        int ans = dfs(i + 1);
        for (int j = i + k - 1; j < n; j++) {
            if (dp[i][j]) {
                ans = Math.max(ans, 1 + dfs(j + 1));
            }
        }
        f[i] = ans;
        return ans;
    }

}
