package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * 2811. Check if it is Possible to Split Array.
 */
class Problem2811 extends LeetcodeProblem {

    private Boolean[][] f;
    private int[]       s;
    private int         m;

    boolean canSplitArray(List<Integer> _nums, int _m) {
        int n = _nums.size();
        f = new Boolean[n][n];
        s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + _nums.get(i - 1);
        }
        m = _m;
        return dfs(0, n - 1);
    }

    private boolean dfs(int i, int j) {
        if (i == j) {
            return true;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        for (int k = i; k < j; k++) {
            boolean a = k == i || s[k + 1] - s[i] >= m;
            boolean b = k == j - 1 || s[j + 1] - s[k + 1] >= m;
            if (a && b && dfs(i, k) && dfs(k + 1, j)) {
                return f[i][j] = true;
            }
        }
        return f[i][j] = false;
    }

}
