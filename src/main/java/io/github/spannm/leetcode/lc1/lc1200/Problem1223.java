package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1223. Dice Roll Simulation.
 */
class Problem1223 extends LeetcodeProblem {

    private Integer[][][] f;
    private int[]         rollMax;

    int dieSimulator(int _n, int[] _rollMax) {
        f = new Integer[_n][7][16];
        rollMax = _rollMax;
        return dfs(0, 0, 0);
    }

    int dfs(int _i, int _j, int _x) {
        if (_i >= f.length) {
            return 1;
        } else if (f[_i][_j][_x] != null) {
            return f[_i][_j][_x];
        }
        long ans = 0;
        for (int k = 1; k <= 6; k++) {
            if (k != _j) {
                ans += dfs(_i + 1, k, 1);
            } else if (_x < rollMax[_j - 1]) {
                ans += dfs(_i + 1, _j, _x + 1);
            }
        }
        ans %= 1000000007;
        return f[_i][_j][_x] = (int) ans;
    }

}
