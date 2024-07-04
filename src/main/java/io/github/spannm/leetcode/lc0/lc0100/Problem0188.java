package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0188 extends LeetcodeProblem {

    int maxProfit(int _k, int[] _prices) {
        int len = _prices.length;
        if (_k >= len / 2) {
            int profit = 0;
            for (int i = 1; i < len; i++) {
                if (_prices[i] > _prices[i - 1]) {
                    profit += _prices[i] - _prices[i - 1];
                }
            }
            return profit;
        }

        int[][] t = new int[_k + 1][len];
        for (int i = 1; i <= _k; i++) {
            int tmpMax = -_prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], _prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - _prices[j]);
            }
        }
        return t[_k][len - 1];
    }

}
