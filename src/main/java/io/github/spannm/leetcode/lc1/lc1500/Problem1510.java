package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1510. Stone Game IV.
 */
class Problem1510 extends LeetcodeProblem {

    private Boolean[] f;

    boolean winnerSquareGame(int n) {
        f = new Boolean[n + 1];
        return dfs(n);
    }

    private boolean dfs(int i) {
        if (i <= 0) {
            return false;
        }
        if (f[i] != null) {
            return f[i];
        }
        for (int j = 1; j <= i / j; j++) {
            if (!dfs(i - j * j)) {
                return f[i] = true;
            }
        }
        return f[i] = false;
    }

}
