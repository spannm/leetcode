package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2920. Maximum Points After Collecting Coins From All Nodes.
 */
class Problem2920 extends LeetcodeProblem {

    private int[]           coins;
    private int             k;
    private Integer[][]     f;
    private List<Integer>[] g;

    int maximumPoints(int[][] _edges, int[] _coins, int _k) {
        coins = _coins;
        k = _k;
        int n = _coins.length;
        f = new Integer[n][15];
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[n];
        g = lists;
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        return dfs(0, -1, 0);
    }

    private int dfs(int _i, int _fa, int _j) {
        if (f[_i][_j] != null) {
            return f[_i][_j];
        }
        int a = (coins[_i] >> _j) - k;
        int b = coins[_i] >> _j + 1;
        for (int c : g[_i]) {
            if (c != _fa) {
                a += dfs(c, _i, _j);
                if (_j < 14) {
                    b += dfs(c, _i, _j + 1);
                }
            }
        }
        return f[_i][_j] = Math.max(a, b);
    }

}
