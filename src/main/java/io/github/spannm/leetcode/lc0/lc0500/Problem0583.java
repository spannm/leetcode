package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0583 extends LeetcodeProblem {

    int minDistance(String _word1, String _word2) {
        int len1 = _word1.length();
        int len2 = _word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i1 = 1; i1 <= len1; i1++) {
            for (int i2 = 1; i2 <= len2; i2++) {
                dp[i1][i2] = _word1.charAt(i1 - 1) == _word2.charAt(i2 - 1)
                    ? dp[i1 - 1][i2 - 1] + 1
                    : Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }

}
