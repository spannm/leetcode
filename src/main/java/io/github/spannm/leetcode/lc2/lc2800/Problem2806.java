package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2806. Account Balance After Rounded Purchase.
 */
class Problem2806 extends LeetcodeProblem {

    int accountBalanceAfterPurchase(int purchaseAmount) {
        int diff = 100;
        int x = 0;
        for (int y = 100; y >= 0; y -= 10) {
            int t = Math.abs(y - purchaseAmount);
            if (t < diff) {
                diff = t;
                x = y;
            }
        }
        return 100 - x;
    }

}
