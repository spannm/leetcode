package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0764 extends LeetcodeProblem {

    int orderOfLargestPlusSign(int _n, int[][] _mines) {
        Set<Integer> banned = new HashSet<>();
        for (int[] mine : _mines) {
            banned.add(mine[0] * _n + mine[1]);
        }

        int[][] dp = new int[_n][_n];

        for (int row = 0; row < _n; row++) {
            int count = 0;
            for (int col = 0; col < _n; col++) {
                count = banned.contains(row * _n + col) ? 0 : count + 1;
                dp[row][col] = count;
            }

            count = 0;
            for (int col = _n - 1; col >= 0; col--) {
                count = banned.contains(row * _n + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }
        }

        int result = 0;
        for (int col = 0; col < _n; col++) {
            int count = 0;
            for (int row = 0; row < _n; row++) {
                count = banned.contains(row * _n + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }

            count = 0;
            for (int row = _n - 1; row >= 0; row--) {
                count = banned.contains(row * _n + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
                result = Math.max(result, dp[row][col]);
            }
        }
        return result;
    }

}
