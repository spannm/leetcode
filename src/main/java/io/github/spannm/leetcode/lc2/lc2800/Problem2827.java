package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2827. Number of Beautiful Integers in the Range.
 */
class Problem2827 extends LeetcodeProblem {

    private String        s;
    private int           k;
    private Integer[][][] f = new Integer[11][21][21];

    int numberOfBeautifulIntegers(int _low, int _high, int _k) {
        k = _k;
        s = String.valueOf(_high);
        int a = dfs(0, 0, 10, true, true);
        s = String.valueOf(_low - 1);
        f = new Integer[11][21][21];
        int b = dfs(0, 0, 10, true, true);
        return a - b;
    }

    int dfs(int pos, int mod, int diff, boolean lead, boolean limit) {
        if (pos >= s.length()) {
            return mod == 0 && diff == 10 ? 1 : 0;
        }
        if (!lead && !limit && f[pos][mod][diff] != null) {
            return f[pos][mod][diff];
        }
        int ans = 0;
        int up = limit ? s.charAt(pos) - '0' : 9;
        for (int i = 0; i <= up; i++) {
            if (i == 0 && lead) {
                ans += dfs(pos + 1, mod, diff, true, limit && i == up);
            } else {
                int nxt = diff + (i % 2 == 1 ? 1 : -1);
                ans += dfs(pos + 1, (mod * 10 + i) % k, nxt, false, limit && i == up);
            }
        }
        if (!lead && !limit) {
            f[pos][mod][diff] = ans;
        }
        return ans;
    }

}
