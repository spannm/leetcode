package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1659. Maximize Grid Happiness.
 */
class Problem1659 extends LeetcodeProblem {

    private int             m;
    private int             n;
    private int             p;
    private final int[][]   h = {{0, 0, 0}, {0, -60, -10}, {0, -10, 40}};
    private Integer[][][][] memo;

    int getMaxGridHappiness(int _m, int _n, int _introvertsCount, int _extrovertsCount) {
        m = _m;
        n = _n;
        p = (int) Math.pow(3, _n - 1);
        memo = new Integer[_m * _n][p * 3][_introvertsCount + 1][_extrovertsCount + 1];
        return dfs(0, 0, _introvertsCount, _extrovertsCount);
    }

    private int dfs(int pos, int pre, int ic, int ec) {
        if (pos == m * n || ic == 0 && ec == 0) {
            return 0;
        }
        if (memo[pos][pre][ic][ec] != null) {
            return memo[pos][pre][ic][ec];
        }
        int ans = 0;
        int up = pre / p;
        int left = pos % n == 0 ? 0 : pre % 3;
        for (int i = 0; i < 3; i++) {
            if (i == 1 && ic == 0 || i == 2 && ec == 0) {
                continue;
            }
            int cur = pre % p * 3 + i;
            int a = h[up][i] + h[left][i];
            int b = dfs(pos + 1, cur, ic - (i == 1 ? 1 : 0), ec - (i == 2 ? 1 : 0));
            int c = i == 1 ? 120 : i == 2 ? 40 : 0;
            ans = Math.max(ans, a + b + c);
        }
        return memo[pos][pre][ic][ec] = ans;
    }

}
