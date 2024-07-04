package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 813. Largest Sum of Averages.
 */
class Problem0813 extends LeetcodeProblem {

    private Double[][] f;
    private int[]      s;
    private int        n;

    double largestSumOfAverages(int[] _nums, int _k) {
        n = _nums.length;
        s = new int[n + 1];
        f = new Double[n + 1][_k + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + _nums[i];
        }
        return dfs(0, _k);
    }

    private double dfs(int _i, int _k) {
        if (_i == n) {
            return 0;
        } else if (_k == 1) {
            return (s[n] - s[_i]) * 1.0 / (n - _i);
        } else if (f[_i][_k] != null) {
            return f[_i][_k];
        }
        double ans = 0;
        for (int j = _i; j < n; j++) {
            double t = (s[j + 1] - s[_i]) * 1.0 / (j - _i + 1) + dfs(j + 1, _k - 1);
            ans = Math.max(ans, t);
        }
        return f[_i][_k] = ans;
    }

}
