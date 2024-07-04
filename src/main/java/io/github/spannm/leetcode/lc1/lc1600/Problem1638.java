package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1638. Count Substrings That Differ by One Character.
 */
class Problem1638 extends LeetcodeProblem {

    int countSubstrings(String _s, String _t) {
        int ans = 0;
        int m = _s.length();
        int n = _t.length();
        int[][] f = new int[m + 1][n + 1];
        int[][] g = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (_s.charAt(i) == _t.charAt(j)) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (_s.charAt(i) == _t.charAt(j)) {
                    g[i][j] = g[i + 1][j + 1] + 1;
                } else {
                    ans += (f[i][j] + 1) * (g[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }

}
