package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2338. Count the Number of Ideal Arrays.
 */
class Problem2338 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;
    private int[][]          f;
    private int[][]          c;
    private int              n;
    private int              m;

    int idealArrays(int _n, int _maxValue) {
        n = _n;
        m = _maxValue;
        f = new int[_maxValue + 1][16];
        for (int[] row : f) {
            Arrays.fill(row, -1);
        }
        c = new int[_n][16];
        for (int i = 0; i < _n; i++) {
            for (int j = 0; j <= i && j < 16; j++) {
                c[i][j] = j == 0 ? 1 : (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dfs(i, 1)) % MOD;
        }
        return ans;
    }

    private int dfs(int _i, int _cnt) {
        if (f[_i][_cnt] != -1) {
            return f[_i][_cnt];
        }
        int res = c[n - 1][_cnt - 1];
        if (_cnt < n) {
            for (int k = 2; k * _i <= m; k++) {
                res = (res + dfs(k * _i, _cnt + 1)) % MOD;
            }
        }
        f[_i][_cnt] = res;
        return res;
    }

}
