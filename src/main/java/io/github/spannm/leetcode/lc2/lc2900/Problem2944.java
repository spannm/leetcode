package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2944. Minimum Number of Coins for Fruits.
 */
class Problem2944 extends LeetcodeProblem {

    private int[] prices;
    private int   len;
    private int[] f;

    int minimumCoins(int[] _prices) {
        prices = _prices;
        len = _prices.length;
        f = new int[len + 1];
        return dfs(1);
    }

    int dfs(int i) {
        if (i > len) {
            return 0;
        }
        if (f[i] == 0) {
            f[i] = 1 << 30;
            for (int j = i + 1; j <= i * 2 + 1; j++) {
                f[i] = Math.min(f[i], prices[i - 1] + dfs(j));
            }
        }
        return f[i];
    }

}
