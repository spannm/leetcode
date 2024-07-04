package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2714. Find Shortest Path with K Hops.
 */
class Problem2714 extends LeetcodeProblem {

    int shortestPathWithHops(int n, int[][] edges, int s, int d, int k) {
        @SuppressWarnings("unchecked")
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, s, 0});
        int[][] dist = new int[n][k + 1];
        final int inf = 1 << 30;
        for (int[] e : dist) {
            Arrays.fill(e, inf);
        }
        dist[s][0] = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int dis = p[0];
            int u = p[1];
            int t = p[2];
            for (int[] e : g[u]) {
                int v = e[0];
                int w = e[1];
                if (t + 1 <= k && dist[v][t + 1] > dis) {
                    dist[v][t + 1] = dis;
                    pq.offer(new int[] {dis, v, t + 1});
                }
                if (dist[v][t] > dis + w) {
                    dist[v][t] = dis + w;
                    pq.offer(new int[] {dis + w, v, t});
                }
            }
        }
        int ans = inf;
        for (int i = 0; i <= k; i++) {
            ans = Math.min(ans, dist[d][i]);
        }
        return ans;
    }

}
