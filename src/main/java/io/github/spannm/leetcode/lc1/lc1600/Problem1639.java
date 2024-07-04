package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/">1639. Number of
 * Ways to Form a Target String Given a Dictionary</a>.
 */
class Problem1639 extends LeetcodeProblem {

    int numWays(String[] _words, String _target) {

        final int mod = 1000000007;
        final int len = _target.length();
        final int max = _words[0].length();

        final int[][] charFreq = new int[max][26];

        for (String word : _words) {
            for (int i = 0; i < max; i++) {
                charFreq[i][word.charAt(i) - 'a']++;
            }
        }

        final long[][] dp = new long[len + 1][max + 1];
        // filling first row of array with 1
        dp[0] = java.util.stream.LongStream.range(0, max + 1).map(e -> 1).toArray();

        for (int i = 1; i <= len; i++) {
            for (int ch = i; ch <= max + i - len; ch++) {
                dp[i][ch] = (dp[i - 1][ch - 1] * charFreq[ch - 1][_target.charAt(i - 1) - 'a'] % mod + dp[i][ch - 1]) % mod;
            }
        }

        return (int) dp[len][max];
    }

}
