package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">121. Best Time to Buy and Sell Stock</a>
 */
class Problem0121 extends LeetcodeProblem {

    int maxProfit(int[] _prices) {
        int buyPrc = _prices[0];
        int maxProfit = 0;
        int newProfit = 0;
        int len = _prices.length;

        for (int day = 1; day < len; day++) {
            if (buyPrc > _prices[day]) {
                buyPrc = _prices[day];
            }
            newProfit = _prices[day] - buyPrc;
            if (newProfit > maxProfit) {
                maxProfit = newProfit;
            }
        }
        return maxProfit;
    }

}
