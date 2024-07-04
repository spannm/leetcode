package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2493. Divide Nodes Into the Maximum Number of Groups.
 */
class Problem2493 extends LeetcodeProblem {

    private List<Integer>[]     g;
    private final List<Integer> arr = new ArrayList<>();
    private boolean[]           vis;
    private int                 n;

    int magnificentSets(int _n, int[][] _edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[_n + 1];
        g = lists;
        n = _n;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }

        vis = new boolean[_n + 1];
        int ans = 0;
        for (int i = 1; i <= _n; i++) {
            if (!vis[i]) {
                dfs(i);
                int t = -1;
                for (int v : arr) {
                    t = Math.max(t, bfs(v));
                }
                if (t == -1) {
                    return -1;
                }
                ans += t;
                arr.clear();
            }
        }
        return ans;
    }

    private int bfs(int _k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1 << 30);
        dist[_k] = 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(_k);
        int ans = 1;
        while (!q.isEmpty()) {
            int i = q.pollFirst();
            for (int j : g[i]) {
                if (dist[j] == 1 << 30) {
                    dist[j] = dist[i] + 1;
                    ans = dist[j];
                    q.offer(j);
                }
            }
        }
        for (int i : arr) {
            if (dist[i] == 1 << 30) {
                dist[i] = ++ans;
            }
        }
        for (int i : arr) {
            for (int j : g[i]) {
                if (Math.abs(dist[i] - dist[j]) != 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    private void dfs(int i) {
        arr.add(i);
        vis[i] = true;
        for (int j : g[i]) {
            if (!vis[j]) {
                dfs(j);
            }
        }
    }

}
