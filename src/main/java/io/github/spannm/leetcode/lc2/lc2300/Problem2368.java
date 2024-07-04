package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2368. Reachable Nodes With Restrictions.
 */
class Problem2368 extends LeetcodeProblem {

    private List<Integer>[] g;
    private boolean[]       vis;
    private int             ans;

    int reachableNodes(int _n, int[][] _edges, int[] _restricted) {
        @SuppressWarnings({"unchecked"})
        List<Integer>[] lists = new List[_n];
        g = lists;
        Arrays.setAll(g, k -> new ArrayList<>());
        vis = new boolean[_n];
        for (int v : _restricted) {
            vis[v] = true;
        }
        for (int[] e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }

        ans = 0;
        dfs(0);
        return ans;
    }

    void dfs(int _u) {
        if (vis[_u]) {
            return;
        }
        ans++;
        vis[_u] = true;
        for (int v : g[_u]) {
            dfs(v);
        }
    }

}
