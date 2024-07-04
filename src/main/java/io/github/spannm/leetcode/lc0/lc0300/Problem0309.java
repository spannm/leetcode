package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0309 extends LeetcodeProblem {

    int maxProfit(int[] _prices) {
        int sell = 0;
        int prevSell = 0;
        int buy = Integer.MIN_VALUE;
        int prevBuy;
        for (int price : _prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - price, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + price, prevSell);
        }
        return sell;
    }

}
