package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/soup-servings/">808. Soup Servings</a>.
 */
class Problem0808 extends LeetcodeProblem {

    double soupServings(final int _totalMl) {
        if (_totalMl > 4800) {
            return 1;
        }
        double[][] dp = new double[_totalMl / 25 + 1][_totalMl / 25 + 1];
        for (double[] dp1 : dp) {
            Arrays.fill(dp1, -1);
        }
        double result = calc(_totalMl, _totalMl, 1, dp);

        dp = null;
        System.gc();

        return result;
    }

    static double calc(final int _a, final int _b, final double _curr, final double[][] _dp) {
        if (_a <= 0 && _b > 0) {
            return _curr;
        } else if (_a <= 0 && _b <= 0) {
            return _curr / 2;
        } else if (_a <= 0 || _b <= 0) {
            return 0;
        } else if (_dp[_a / 25][_b / 25] != -1) {
            return _dp[_a / 25][_b / 25];
        }
        final double res = 0.25 * (calc(_a - 100, _b, _curr, _dp)
            + calc(_a - 75, _b - 25, _curr, _dp)
            + calc(_a - 50, _b - 50, _curr, _dp)
            + calc(_a - 25, _b - 75, _curr, _dp));
        _dp[_a / 25][_b / 25] = res;
        return res;
    }

}
