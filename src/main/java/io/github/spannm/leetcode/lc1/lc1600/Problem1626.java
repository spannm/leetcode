package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1626 extends LeetcodeProblem {

    int bestTeamScore(int[] _scores, int[] _ages) {
        final int len = _scores.length;
        int[][] players = new int[len][2];
        for (int i = 0; i < len; i++) {
            players[i][0] = _ages[i];
            players[i][1] = _scores[i];
        }

        Arrays.sort(players, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] dp = new int[len];
        dp[0] = players[0][1];
        for (int i = 1; i < len; i++) {
            int maxScoreUpToAge = players[i][1];
            for (int j = 0; j < i; j++) {
                if (players[i][1] >= players[j][1]) {
                    maxScoreUpToAge = Math.max(maxScoreUpToAge, dp[j] + players[i][1]);
                }
            }
            dp[i] = maxScoreUpToAge;
        }
        return Arrays.stream(dp).max().orElse(0);
    }

}
