package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2291. Maximum Profit From Trading Stocks.
 */
class Problem2291 extends LeetcodeProblem {

    int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[] f = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int a = present[i];
            int b = future[i];
            for (int j = budget; j >= a; j--) {
                f[j] = Math.max(f[j], f[j - a] + b - a);
            }
        }
        return f[budget];
    }

}
