package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0514 extends LeetcodeProblem {

    int findRotateSteps(String _ring, String _key) {
        int rlen = _ring.length();
        int klen = _key.length();
        int[][] dp = new int[klen + 1][rlen];
        for (int i = klen - 1; i >= 0; i--) {
            for (int j = 0; j < rlen; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < rlen; k++) {
                    if (_ring.charAt(k) == _key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, rlen - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        return dp[0][0] + klen;
    }

}
