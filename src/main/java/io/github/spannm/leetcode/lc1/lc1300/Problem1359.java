package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/"> 1359. Count All Valid Pickup
 * and Delivery Options</a>.
 */
class Problem1359 extends LeetcodeProblem {

    int countOrders(final int _orderCount) {
        final int mod = 1_000_000_000 + 7;
        long dp = 1;

        for (int i = 2; i <= _orderCount; i++) {
            dp *= i * (2L * i - 1);
            dp %= mod;
        }
        return (int) dp;
    }

}
