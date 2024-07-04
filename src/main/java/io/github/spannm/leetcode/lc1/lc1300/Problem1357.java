package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1357 extends LeetcodeProblem {

    static class Cashier {

        private int                         customerCount;
        private final int                   n;
        private final Map<Integer, Integer> productsToPrices;
        private final int                   discount;

        Cashier(int _n, int _discount, int[] _products, int[] _prices) {
            n = _n;
            customerCount = 0;
            discount = _discount;
            productsToPrices = new HashMap<>();
            for (int i = 0; i < _products.length; i++) {
                productsToPrices.put(_products[i], _prices[i]);
            }
        }

        double getBill(int[] _product, int[] _amount) {
            double totalPrice = 0;
            for (int i = 0; i < _product.length; i++) {
                totalPrice += productsToPrices.get(_product[i]) * _amount[i];
            }
            if (customerCount + 1 == n) {

                totalPrice *= (double) (100 - discount) / 100;
                customerCount = 0;
            } else {
                customerCount++;
            }
            return totalPrice;
        }
    }

}
