package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2093. Minimum Cost to Reach City With Discounts.
 */
class Problem2093 extends LeetcodeProblem {

    int minimumCost(int n, int[][] highways, int discounts) {
        @SuppressWarnings("unchecked")
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (var e : highways) {
            int a = e[0];
            int b = e[1];
            int c = e[2];
            g[a].add(new int[] {b, c});
            g[b].add(new int[] {a, c});
        }
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[] {0, 0, 0});
        int[][] dist = new int[n][discounts + 1];
        for (var e : dist) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        while (!q.isEmpty()) {
            var p = q.poll();
            int cost = p[0];
            int i = p[1];
            int k = p[2];
            if (k > discounts || dist[i][k] <= cost) {
                continue;
            }
            if (i == n - 1) {
                return cost;
            }
            dist[i][k] = cost;
            for (int[] nxt : g[i]) {
                int j = nxt[0];
                int v = nxt[1];
                q.offer(new int[] {cost + v, j, k});
                q.offer(new int[] {cost + v / 2, j, k + 1});
            }
        }
        return -1;
    }

}
