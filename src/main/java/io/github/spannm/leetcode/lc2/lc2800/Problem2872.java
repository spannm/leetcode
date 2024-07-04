package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2872. Maximum Number of K-Divisible Components.
 */
class Problem2872 extends LeetcodeProblem {

    private int             ans;
    private List<Integer>[] g;
    private int[]           values;
    private int             k;

    int maxKDivisibleComponents(int _n, int[][] _edges, int[] _values, int _k) {
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[_n];
        g = lists;
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        values = _values;
        k = _k;
        dfs(0, -1);
        return ans;
    }

    private long dfs(int _i, int _fa) {
        long s = values[_i];
        for (int j : g[_i]) {
            if (j != _fa) {
                s += dfs(j, _i);
            }
        }
        ans += s % k == 0 ? 1 : 0;
        return s;
    }

}
