package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1059. All Paths from Source Lead to Destination.
 */
class Problem1059 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int[]           f;
    private boolean[]       vis;
    private int             k;

    @SuppressWarnings("unchecked")
    boolean leadsToDestination(int _n, int[][] _edges, int _source, int _destination) {
        vis = new boolean[_n];
        g = new List[_n];
        k = _destination;
        f = new int[_n];
        Arrays.setAll(g, key -> new ArrayList<>());
        for (var e : _edges) {
            g[e[0]].add(e[1]);
        }
        return dfs(_source);
    }

    private boolean dfs(int _i) {
        if (_i == k) {
            return g[_i].isEmpty();
        } else if (f[_i] != 0) {
            return f[_i] == 1;
        } else if (vis[_i] || g[_i].isEmpty()) {
            return false;
        }
        vis[_i] = true;
        for (int j : g[_i]) {
            if (!dfs(j)) {
                f[_i] = -1;
                return false;
            }
        }
        f[_i] = 1;
        return true;
    }

}
