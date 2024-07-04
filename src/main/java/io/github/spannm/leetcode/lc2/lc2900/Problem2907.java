package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2907. Maximum Profitable Triplets With Increasing Prices I.
 */
class Problem2907 extends LeetcodeProblem {

    int maxProfit(int[] prices, int[] profits) {
        int n = prices.length;
        int ans = -1;
        for (int j = 0; j < n; j++) {
            int left = 0;
            int right = 0;
            for (int i = 0; i < j; i++) {
                if (prices[i] < prices[j]) {
                    left = Math.max(left, profits[i]);
                }
            }
            for (int k = j + 1; k < n; k++) {
                if (prices[j] < prices[k]) {
                    right = Math.max(right, profits[k]);
                }
            }
            if (left > 0 && right > 0) {
                ans = Math.max(ans, left + profits[j] + right);
            }
        }
        return ans;
    }

}
