package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1443. Minimum Time to Collect All Apples in a Tree.
 */
class Problem1443 extends LeetcodeProblem {

    int minTime(int _n, int[][] _edges, List<Boolean> _hasApple) {
        boolean[] vis = new boolean[_n];
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[_n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : _edges) {
            int u = e[0];
            int v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        return dfs(0, 0, g, _hasApple, vis);
    }

    private int dfs(int u, int cost, List<Integer>[] g, List<Boolean> hasApple, boolean[] vis) {
        if (vis[u]) {
            return 0;
        }
        vis[u] = true;
        int nxtCost = 0;
        for (int v : g[u]) {
            nxtCost += dfs(v, 2, g, hasApple, vis);
        }
        if (!hasApple.get(u) && nxtCost == 0) {
            return 0;
        }
        return cost + nxtCost;
    }

}
