package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/frog-jump/">403. Frog Jump</a>.
 */
class Problem0403 extends LeetcodeProblem {

    boolean canCross(int[] _stones) {
        int nbStones = _stones.length;
        boolean[][] dp = new boolean[nbStones][nbStones + 1];
        dp[0][1] = true;
        boolean result = false;

        for (int stone = 1; stone < nbStones; stone++) {
            for (int jumpLen = 0; jumpLen < stone; jumpLen++) {
                int jump = _stones[stone] - _stones[jumpLen];

                if (jump <= jumpLen + 1) {
                    dp[stone][jump] = dp[jumpLen][jump - 1] || dp[jumpLen][jump] || dp[jumpLen][jump + 1];
                    boolean isLast = stone == nbStones - 1;
                    if (isLast && dp[stone][jump]) {
                        result = true;
                        break;
                    }
                }
            }
        }

        _stones = null;
        dp = null;
        System.gc();

        return result;
    }

}
