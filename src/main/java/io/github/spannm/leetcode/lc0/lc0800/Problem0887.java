package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 887. Super Egg Drop.
 */
class Problem0887 extends LeetcodeProblem {

    private int[][] f;

    int superEggDrop(int _k, int _n) {
        f = new int[_n + 1][_k + 1];
        return dfs(_n, _k);
    }

    private int dfs(int _i, int _j) {
        if (_i < 1) {
            return 0;
        }
        if (_j == 1) {
            return _i;
        }
        if (f[_i][_j] != 0) {
            return f[_i][_j];
        }
        int l = 1;
        int r = _i;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            int a = dfs(mid - 1, _j - 1);
            int b = dfs(_i - mid, _j);
            if (a <= b) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return f[_i][_j] = Math.max(dfs(l - 1, _j - 1), dfs(_i - l, _j)) + 1;
    }

}
