package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1335. Minimum Difficulty of a Job Schedule.
 */
class Problem1335 extends LeetcodeProblem {

    int minDifficulty(int[] _jobDifficulty, int _days) {
        final int inf = 1 << 30;
        int nbJobs = _jobDifficulty.length;
        int[][] dp = new int[nbJobs + 1][_days + 1];
        for (int[] days : dp) {
            Arrays.fill(days, inf);
        }
        dp[0][0] = 0;
        for (int j = 1; j <= nbJobs; j++) {
            for (int d = 1; d <= Math.min(_days, j); d++) {
                int max = 0;
                for (int k = j; k > 0; k--) {
                    max = Math.max(max, _jobDifficulty[k - 1]);
                    dp[j][d] = Math.min(dp[j][d], dp[k - 1][d - 1] + max);
                }
            }
        }
        return dp[nbJobs][_days] >= inf ? -1 : dp[nbJobs][_days];
    }

}
