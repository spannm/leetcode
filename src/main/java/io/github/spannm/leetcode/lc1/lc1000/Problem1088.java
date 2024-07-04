package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1088. Confusing Number II.
 */
class Problem1088 extends LeetcodeProblem {

    private final int[] d = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    private String      s;

    int confusingNumberII(int _n) {
        s = String.valueOf(_n);
        return dfs(0, 1, 0);
    }

    private int dfs(int _pos, int _limit, int _x) {
        if (_pos >= s.length()) {
            return check(_x) ? 1 : 0;
        }
        int up = _limit == 1 ? s.charAt(_pos) - '0' : 9;
        int ans = 0;
        for (int i = 0; i <= up; i++) {
            if (d[i] != -1) {
                ans += dfs(_pos + 1, _limit == 1 && i == up ? 1 : 0, _x * 10 + i);
            }
        }
        return ans;
    }

    private boolean check(int _x) {
        int y = 0;
        for (int t = _x; t > 0; t /= 10) {
            int v = t % 10;
            y = y * 10 + d[v];
        }
        return _x != y;
    }

}
