package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2473. Minimum Cost to Buy Apples.
 */
class Problem2473 extends LeetcodeProblem {

    private static final int INF = 0x3f3f3f3f;
    private int              k;
    private int[]            cost;
    private int[]            dist;
    private List<int[]>[]    g;

    long[] minCost(int _n, int[][] _roads, int[] _appleCost, int _k) {
        cost = _appleCost;
        @SuppressWarnings("unchecked")
        List<int[]>[] lists = new List[_n];
        g = lists;
        dist = new int[_n];
        k = _k;
        for (int i = 0; i < _n; i++) {
            g[i] = new ArrayList<>();
        }
        for (var e : _roads) {
            int a = e[0] - 1;
            int b = e[1] - 1;
            int c = e[2];
            g[a].add(new int[] {b, c});
            g[b].add(new int[] {a, c});
        }
        long[] ans = new long[_n];
        for (int i = 0; i < _n; i++) {
            ans[i] = dijkstra(i);
        }
        return ans;
    }

    private long dijkstra(int _u) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[] {0, _u});
        Arrays.fill(dist, INF);
        dist[_u] = 0;
        long ans = Long.MAX_VALUE;
        while (!q.isEmpty()) {
            var p = q.poll();
            int d = p[0];
            _u = p[1];
            ans = Math.min(ans, cost[_u] + (long) (k + 1) * d);
            for (var ne : g[_u]) {
                int v = ne[0];
                int w = ne[1];
                if (dist[v] > dist[_u] + w) {
                    dist[v] = dist[_u] + w;
                    q.offer(new int[] {dist[v], v});
                }
            }
        }
        return ans;
    }

}
