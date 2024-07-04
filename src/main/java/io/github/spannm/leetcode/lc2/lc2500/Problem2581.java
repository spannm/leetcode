package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2581. Count Number of Possible Root Nodes.
 */
class Problem2581 extends LeetcodeProblem {

    private List<Integer>[]          g;
    private final Map<Long, Integer> gs = new HashMap<>();
    private int                      ans;
    private int                      k;
    private int                      cnt;
    private int                      n;

    int rootCount(int[][] _edges, int[][] _guesses, int _k) {
        k = _k;
        n = _edges.length + 1;
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[n];
        g = lists;
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (var e : _guesses) {
            int a = e[0];
            int b = e[1];
            gs.merge(f(a, b), 1, Integer::sum);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs1(int i, int fa) {
        for (int j : g[i]) {
            if (j != fa) {
                cnt += gs.getOrDefault(f(i, j), 0);
                dfs1(j, i);
            }
        }
    }

    private void dfs2(int i, int fa) {
        ans += cnt >= k ? 1 : 0;
        for (int j : g[i]) {
            if (j != fa) {
                int a = gs.getOrDefault(f(i, j), 0);
                int b = gs.getOrDefault(f(j, i), 0);
                cnt -= a;
                cnt += b;
                dfs2(j, i);
                cnt -= b;
                cnt += a;
            }
        }
    }

    private long f(int i, int j) {
        return 1L * i * n + j;
    }

}
