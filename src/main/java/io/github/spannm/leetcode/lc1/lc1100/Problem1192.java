package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1192. Critical Connections in a Network.
 */
class Problem1192 extends LeetcodeProblem {

    private int                       now;
    private List<Integer>[]           g;
    private final List<List<Integer>> ans = new ArrayList<>();
    private int[]                     dfn;
    private int[]                     low;

    List<List<Integer>> criticalConnections(int _n, List<List<Integer>> _connections) {
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[_n];
        g = lists;
        Arrays.setAll(g, k -> new ArrayList<>());
        dfn = new int[_n];
        low = new int[_n];
        for (var e : _connections) {
            int a = e.get(0);
            int b = e.get(1);
            g[a].add(b);
            g[b].add(a);
        }
        tarjan(0, -1);
        return ans;
    }

    private void tarjan(int _a, int _fa) {
        dfn[_a] = low[_a] = ++now;
        for (int b : g[_a]) {
            if (b == _fa) {
                continue;
            }
            if (dfn[b] == 0) {
                tarjan(b, _a);
                low[_a] = Math.min(low[_a], low[b]);
                if (low[b] > dfn[_a]) {
                    ans.add(List.of(_a, b));
                }
            } else {
                low[_a] = Math.min(low[_a], dfn[b]);
            }
        }
    }

}
