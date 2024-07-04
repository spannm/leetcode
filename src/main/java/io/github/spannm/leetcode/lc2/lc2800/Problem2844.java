package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2844. Minimum Operations to Make a Special Number.
 */
class Problem2844 extends LeetcodeProblem {

    private String      num;
    private int         len;
    private Integer[][] f;

    int minimumOperations(String _num) {
        num = _num;
        len = _num.length();
        f = new Integer[len][25];
        return dfs(0, 0);
    }

    private int dfs(int i, int k) {
        if (i == len) {
            return k == 0 ? 0 : len;
        }
        if (f[i][k] != null) {
            return f[i][k];
        }
        f[i][k] = dfs(i + 1, k) + 1;
        f[i][k] = Math.min(f[i][k], dfs(i + 1, (k * 10 + num.charAt(i) - '0') % 25));
        return f[i][k];
    }

}
