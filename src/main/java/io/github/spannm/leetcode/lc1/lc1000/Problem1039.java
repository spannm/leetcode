package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1039. Minimum Score Triangulation of Polygon.
 */
class Problem1039 extends LeetcodeProblem {

    private int[]       values;
    private Integer[][] f;

    int minScoreTriangulation(int[] _values) {
        int n = _values.length;
        values = _values;
        f = new Integer[n][n];
        return dfs(0, n - 1);
    }

    private int dfs(int _i, int _j) {
        if (_i + 1 == _j) {
            return 0;
        }
        if (f[_i][_j] != null) {
            return f[_i][_j];
        }
        int ans = 1 << 30;
        for (int k = _i + 1; k < _j; k++) {
            ans = Math.min(ans, dfs(_i, k) + dfs(k, _j) + values[_i] * values[k] * values[_j]);
        }
        return f[_i][_j] = ans;
    }

}
