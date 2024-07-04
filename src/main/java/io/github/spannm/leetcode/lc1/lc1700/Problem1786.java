package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1786. Number of Restricted Paths From First to Last Node.
 */
class Problem1786 extends LeetcodeProblem {

    private static final int INF = Integer.MAX_VALUE;
    private static final int MOD = (int) 1e9 + 7;
    private List<int[]>[]    g;
    private int[]            dist;
    private int[]            f;
    private int              n;

    int countRestrictedPaths(int _n, int[][] _edges) {
        n = _n;
        @SuppressWarnings("unchecked")
        List<int[]>[] lists = new List[_n + 1];
        g = lists;
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : _edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[] {0, _n});
        dist = new int[_n + 1];
        f = new int[_n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(f, -1);
        dist[_n] = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int u = p[1];
            for (int[] ne : g[u]) {
                int v = ne[0];
                int w = ne[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    q.offer(new int[] {dist[v], v});
                }
            }
        }
        return dfs(1);
    }

    private int dfs(int i) {
        if (f[i] != -1) {
            return f[i];
        }
        if (i == n) {
            return 1;
        }
        int ans = 0;
        for (int[] ne : g[i]) {
            int j = ne[0];
            if (dist[i] > dist[j]) {
                ans = (ans + dfs(j)) % MOD;
            }
        }
        f[i] = ans;
        return ans;
    }

}
