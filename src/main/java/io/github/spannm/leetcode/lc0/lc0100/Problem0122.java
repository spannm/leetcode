package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">122. Best Time to Buy and Sell Stock
 * II</a>.
 */
class Problem0122 extends LeetcodeProblem {

    int maxProfit(int[] _prices) {
        int pro = 0;
        int i = 0;
        while (i < _prices.length - 1) {
            while (i < _prices.length - 1 && _prices[i] >= _prices[i + 1]) {
                i++;
            }
            int valley = _prices[i];
            while (i < _prices.length - 1 && _prices[i] <= _prices[i + 1]) {
                i++;
            }
            int peak = _prices[i];
            pro += peak - valley;
        }
        return pro;
    }

}
