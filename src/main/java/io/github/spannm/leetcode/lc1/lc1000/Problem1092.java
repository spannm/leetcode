package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1092. Shortest Common Supersequence.
 */
class Problem1092 extends LeetcodeProblem {

    String shortestCommonSupersequence(String _s1, String _s2) {
        int m = _s1.length();
        int n = _s2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (_s1.charAt(i - 1) == _s2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        int i = m;
        int j = n;
        StringBuilder ans = new StringBuilder();
        while (i > 0 || j > 0) {
            if (i == 0) {
                ans.append(_s2.charAt(--j));
            } else if (j == 0) {
                ans.append(_s1.charAt(--i));
            } else {
                if (f[i][j] == f[i - 1][j]) {
                    ans.append(_s1.charAt(--i));
                } else if (f[i][j] == f[i][j - 1]) {
                    ans.append(_s2.charAt(--j));
                } else {
                    ans.append(_s1.charAt(--i));
                    j--;
                }
            }
        }
        return ans.reverse().toString();
    }

}
