package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 882. Reachable Nodes In Subdivided Graph.
 */
class Problem0882 extends LeetcodeProblem {

    int reachableNodes(int[][] _edges, int _maxMoves, int _n) {
        @SuppressWarnings("unchecked")
        List<int[]>[] g = new List[_n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : _edges) {
            int u = e[0];
            int v = e[1];
            int cnt = e[2] + 1;
            g[u].add(new int[] {v, cnt});
            g[v].add(new int[] {u, cnt});
        }
        int[] dist = new int[_n];
        Arrays.fill(dist, 1 << 30);
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[] {0, 0});
        dist[0] = 0;
        while (!q.isEmpty()) {
            var p = q.poll();
            int d = p[0];
            int u = p[1];
            for (var nxt : g[u]) {
                int v = nxt[0];
                int cnt = nxt[1];
                if (d + cnt < dist[v]) {
                    dist[v] = d + cnt;
                    q.offer(new int[] {dist[v], v});
                }
            }
        }
        int ans = 0;
        for (int d : dist) {
            if (d <= _maxMoves) {
                ans++;
            }
        }
        for (var e : _edges) {
            int u = e[0];
            int v = e[1];
            int cnt = e[2];
            int a = Math.min(cnt, Math.max(0, _maxMoves - dist[u]));
            int b = Math.min(cnt, Math.max(0, _maxMoves - dist[v]));
            ans += Math.min(cnt, a + b);
        }
        return ans;
    }

}
