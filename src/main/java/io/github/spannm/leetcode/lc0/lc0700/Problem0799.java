package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/champagne-tower/">799. Champagne Tower</a>.
 */
class Problem0799 extends LeetcodeProblem {

    double champagneTower(final int _poured, final int _queryRow, final int _queryGlass) {
        double[][] dp = new double[_queryRow + 2][_queryRow + 2];
        dp[0][0] = _poured;
        for (int row = 0; row <= _queryRow; row++) {
            for (int col = 0; col <= row; col++) {
                double quantity = (dp[row][col] - 1.0) / 2.0;
                if (quantity > 0) {
                    dp[row + 1][col] += quantity;
                    dp[row + 1][col + 1] += quantity;
                }
            }
        }

        double answer = Math.min(dp[_queryRow][_queryGlass], 1.0);
        dp = null;
        return answer;
    }

}
