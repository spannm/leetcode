package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/new-21-game/">837. New 21 Game</a>.
 */
class Problem0837 extends LeetcodeProblem {

    static double new21Game(final int _n, final int _k, final int _maxPts) {
        final double[] dp = new double[_n + 1];
        dp[0] = 1;
        double sum = _k > 0 ? 1 : 0;
        for (int i = 1; i <= _n; i++) {
            dp[i] = sum / _maxPts;
            if (i < _k) {
                sum += dp[i];
            }
            if (i - _maxPts >= 0 && i - _maxPts < _k) {
                sum -= dp[i - _maxPts];
            }
        }
        return IntStream.rangeClosed(_k, _n).mapToDouble(i -> dp[i]).sum();
    }

}
