package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2400. Number of Ways to Reach a Position After Exactly k Steps.
 */
class Problem2400 extends LeetcodeProblem {

    private Integer[][] f;
    private final int   mod = (int) 1e9 + 7;

    int numberOfWays(int startPos, int endPos, int k) {
        f = new Integer[k + 1][k + 1];
        return dfs(Math.abs(startPos - endPos), k);
    }

    private int dfs(int i, int j) {
        if (i > j || j < 0) {
            return 0;
        }
        if (j == 0) {
            return i == 0 ? 1 : 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = dfs(i + 1, j - 1) + dfs(Math.abs(i - 1), j - 1);
        ans %= mod;
        return f[i][j] = ans;
    }

}
