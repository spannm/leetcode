package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">714. Best Time to Buy
 * and Sell Stock with Transaction Fee</a>.
 */
class Problem0714 extends LeetcodeProblem {

    int maxProfit(int[] _prices, int _fee) {
        int profit = 0;
        int effBuyPrice = _prices[0];
        for (int i = 1; i < _prices.length; i++) {
            profit = Math.max(profit, _prices[i] - effBuyPrice - _fee);
            effBuyPrice = Math.min(effBuyPrice, _prices[i] - profit);
        }
        return profit;
    }

}
