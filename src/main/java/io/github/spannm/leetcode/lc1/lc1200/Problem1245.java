package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1245. Tree Diameter.
 */
class Problem1245 extends LeetcodeProblem {

    private Map<Integer, Set<Integer>> g;
    private boolean[]                  vis;
    private int                        next;
    private int                        ans;

    int treeDiameter(int[][] _edges) {
        int n = _edges.length;
        ans = 0;
        g = new HashMap<>();
        for (int[] e : _edges) {
            g.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new HashSet<>()).add(e[0]);
        }
        vis = new boolean[n + 1];
        next = _edges[0][0];
        dfs(next, 0);
        vis = new boolean[n + 1];
        dfs(next, 0);
        return ans;
    }

    void dfs(int _u, int _t) {
        if (vis[_u]) {
            return;
        }
        vis[_u] = true;
        if (ans < _t) {
            ans = _t;
            next = _u;
        }
        for (int v : g.get(_u)) {
            dfs(v, _t + 1);
        }
    }

}
