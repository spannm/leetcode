package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/painting-the-walls/">2742. Painting the Walls</a>.
 */
class Problem2742 extends LeetcodeProblem {

    static int paintWalls(int[] _cost, int[] _time) {
        final int len = _cost.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1000000000);
        dp[0] = 0;
        for (int i1 = 0; i1 < len; i1++) {
            for (int i2 = len; i2 > 0; i2--) {
                dp[i2] = Math.min(dp[i2], dp[Math.max(i2 - _time[i1] - 1, 0)] + _cost[i1]);
            }
        }
        int answer = dp[len];

        _cost = null;
        _time = null;
        dp = null;

        return answer;
    }

}
