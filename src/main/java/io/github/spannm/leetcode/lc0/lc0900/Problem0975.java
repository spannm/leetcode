package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeMap;

/**
 * 975. Odd Even Jump.
 */
class Problem0975 extends LeetcodeProblem {

    private int         n;
    private Integer[][] f;
    private int[][]     g;

    int oddEvenJumps(int[] _arr) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        n = _arr.length;
        f = new Integer[n][2];
        g = new int[n][2];
        for (int i = n - 1; i >= 0; i--) {
            var hi = tm.ceilingEntry(_arr[i]);
            g[i][1] = hi == null ? -1 : hi.getValue();
            var lo = tm.floorEntry(_arr[i]);
            g[i][0] = lo == null ? -1 : lo.getValue();
            tm.put(_arr[i], i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(i, 1);
        }
        return ans;
    }

    private int dfs(int _i, int _k) {
        if (_i == n - 1) {
            return 1;
        } else if (g[_i][_k] == -1) {
            return 0;
        } else if (f[_i][_k] != null) {
            return f[_i][_k];
        }
        return f[_i][_k] = dfs(g[_i][_k], _k ^ 1);
    }

}
