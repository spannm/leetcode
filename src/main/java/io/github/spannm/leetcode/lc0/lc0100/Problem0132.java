package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning-ii/">132. Palindrome Partitioning II</a>.
 */
class Problem0132 extends LeetcodeProblem {

    int minCut(String _str) {
        final int len = _str.length();
        char[] chars = _str.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int[] cut = new int[len];

        for (int i = 0; i < len; i++) {
            cut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (chars[i] == chars[j] && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j == 0) {
                        cut[i] = 0;
                    } else {
                        cut[i] = Math.min(cut[i], cut[j - 1] + 1);
                    }
                }
            }
        }

        int answer = cut[len - 1];

        chars = null;
        dp = null;
        cut = null;

        return answer;
    }

}
