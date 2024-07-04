package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2189. Number of Ways to Build House of Cards.
 */
class Problem2189 extends LeetcodeProblem {

    private Integer[][] f;

    int houseOfCards(int n) {
        f = new Integer[n + 1][n / 3];
        return dfs(n, 0);
    }

    private int dfs(int n, int k) {
        int x = 3 * k + 2;
        if (x > n) {
            return 0;
        }
        if (x == n) {
            return 1;
        }
        if (f[n][k] != null) {
            return f[n][k];
        }
        return f[n][k] = dfs(n - x, k + 1) + dfs(n, k + 1);
    }

}
