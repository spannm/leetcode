package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2467. Most Profitable Path in a Tree.
 */
class Problem2467 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int[]           amount;
    private int[]           ts;
    private int             ans = Integer.MIN_VALUE;

    int mostProfitablePath(int[][] _edges, int _bob, int[] _amount) {
        int n = _edges.length + 1;
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[n];
        g = lists;
        ts = new int[n];
        amount = _amount;
        Arrays.setAll(g, k -> new ArrayList<>());
        Arrays.fill(ts, n);
        for (var e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs1(_bob, -1, 0);
        ts[_bob] = 0;
        dfs2(0, -1, 0, 0);
        return ans;
    }

    boolean dfs1(int _i, int _fa, int _t) {
        if (_i == 0) {
            ts[_i] = Math.min(ts[_i], _t);
            return true;
        }
        for (int j : g[_i]) {
            if (j != _fa && dfs1(j, _i, _t + 1)) {
                ts[j] = Math.min(ts[j], _t + 1);
                return true;
            }
        }
        return false;
    }

    void dfs2(int _i, int _fa, int _t, int _v) {
        if (_t == ts[_i]) {
            _v += amount[_i] >> 1;
        } else if (_t < ts[_i]) {
            _v += amount[_i];
        }
        if (g[_i].size() == 1 && g[_i].get(0) == _fa) {
            ans = Math.max(ans, _v);
            return;
        }
        for (int j : g[_i]) {
            if (j != _fa) {
                dfs2(j, _i, _t + 1, _v);
            }
        }
    }

}
