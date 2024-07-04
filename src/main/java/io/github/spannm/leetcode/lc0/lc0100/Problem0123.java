package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">123. Best Time to Buy and Sell Stock
 * III</a>.
 */
class Problem0123 extends LeetcodeProblem {

    int maxProfit(int[] _prices) {
        int b1 = Integer.MIN_VALUE;
        int b2 = Integer.MIN_VALUE;
        int s1 = 0;
        int s2 = 0;
        for (int price : _prices) {
            b1 = Math.max(b1, -price);
            s1 = Math.max(s1, b1 + price);
            b2 = Math.max(b2, s1 - price);
            s2 = Math.max(s2, b2 + price);
        }
        _prices = null;
        return s2;
    }

}
