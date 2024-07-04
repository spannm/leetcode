package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">1312. Minimum Insertion
 * Steps to Make a String Palindrome</a>.
 */
class Problem1312 extends LeetcodeProblem {

    // Keeping the longest palindromic subsequence common and rest elements will be add to the string resulting in the
    // min number of operations.
    // length of given string - longest palindromic string length will be the answer
    int minInsertions(String _str) {
        return _str.length() - calc(_str);
    }

    static int calc(String _str) {
        final int len = _str.length();
        final char[] input = _str.toCharArray();
        final char[] reversed = new char[len];
        final int[][] dp = new int[len + 1][len + 1];

        for (int i = len - 1; i >= 0; i--) {
            reversed[len - i - 1] = input[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int r = len - 1; r >= 0; r--) {
                if (input[i] == reversed[r]) {
                    dp[i][r] = 1 + dp[i + 1][r + 1];
                } else {
                    dp[i][r] = Math.max(dp[i + 1][r], dp[i][r + 1]);
                }
            }
        }
        return dp[0][0];
    }

}
