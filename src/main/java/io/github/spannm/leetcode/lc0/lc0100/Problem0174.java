package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/dungeon-game/">174. Dungeon Game</a>.
 */
class Problem0174 extends LeetcodeProblem {

    int calculateMinimumHP(int[][] _dungeon) {
        if (_dungeon == null || _dungeon.length == 0) {
            return 0;
        }

        int h = _dungeon.length;
        int w = _dungeon[0].length;
        int[][] dp = new int[h][w];
        dp[h - 1][w - 1] = _dungeon[h - 1][w - 1] > 0 ? 1 : 1 - _dungeon[h - 1][w - 1];

        for (int i = h - 2; i >= 0; i--) {
            int temp = dp[i + 1][w - 1] - _dungeon[i][w - 1];
            dp[i][w - 1] = Math.max(1, temp);
        }

        for (int j = w - 2; j >= 0; j--) {
            int temp = dp[h - 1][j + 1] - _dungeon[h - 1][j];
            dp[h - 1][j] = Math.max(temp, 1);
        }

        for (int i = h - 2; i >= 0; i--) {
            for (int j = w - 2; j >= 0; j--) {
                int down = Math.max(1, dp[i + 1][j] - _dungeon[i][j]);
                int right = Math.max(1, dp[i][j + 1] - _dungeon[i][j]);
                dp[i][j] = Math.min(down, right);
            }
        }

        return dp[0][0];
    }

}
