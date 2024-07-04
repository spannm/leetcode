package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1216. Valid Palindrome III.
 */
class Problem1216 extends LeetcodeProblem {

    boolean isValidPalindrome(String _s, int _k) {
        int n = _s.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (_s.charAt(i) == _s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
                if (f[i][j] + _k >= n) {
                    return true;
                }
            }
        }
        return false;
    }

}
