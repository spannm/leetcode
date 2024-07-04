package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1475 extends LeetcodeProblem {

    int[] finalPrices(int[] _prices) {
        int[] result = new int[_prices.length];
        for (int i = 0; i < _prices.length; i++) {
            boolean foundDiscount = false;
            for (int j = i + 1; j < _prices.length; j++) {
                if (_prices[j] <= _prices[i]) {
                    result[i] = _prices[i] - _prices[j];
                    foundDiscount = true;
                    break;
                }
            }
            if (!foundDiscount) {
                result[i] = _prices[i];
            }
        }
        result[_prices.length - 1] = _prices[_prices.length - 1];
        return result;
    }

}
