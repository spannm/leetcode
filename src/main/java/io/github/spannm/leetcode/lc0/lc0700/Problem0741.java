package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 741. Cherry Pickup.
 */
class Problem0741 extends LeetcodeProblem {

    int cherryPickup(int[][] _grid) {
        int nbRows = _grid.length;
        int[][][] dp = new int[nbRows * 2][nbRows][nbRows];
        dp[0][0][0] = _grid[0][0];
        for (int k = 1; k < nbRows * 2 - 1; k++) {
            for (int i1 = 0; i1 < nbRows; i1++) {
                for (int i2 = 0; i2 < nbRows; i2++) {
                    int j1 = k - i1;
                    int j2 = k - i2;
                    dp[k][i1][i2] = Integer.MIN_VALUE;
                    if (j1 < 0 || j1 >= nbRows || j2 < 0 || j2 >= nbRows || _grid[i1][j1] == -1
                        || _grid[i2][j2] == -1) {
                        continue;
                    }
                    int t = _grid[i1][j1];
                    if (i1 != i2) {
                        t += _grid[i2][j2];
                    }
                    for (int x1 = i1 - 1; x1 <= i1; x1++) {
                        for (int x2 = i2 - 1; x2 <= i2; x2++) {
                            if (x1 >= 0 && x2 >= 0) {
                                dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][x1][x2] + t);
                            }
                        }
                    }
                }
            }
        }
        return Math.max(0, dp[nbRows * 2 - 2][nbRows - 1][nbRows - 1]);
    }

}
