package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2603. Collect Coins in a Tree.
 */
class Problem2603 extends LeetcodeProblem {

    int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        @SuppressWarnings("unchecked")
        Set<Integer>[] g = new Set[n];
        Arrays.setAll(g, k -> new HashSet<>());
        for (var e : edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (coins[i] == 0 && g[i].size() == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : g[i]) {
                g[j].remove(i);
                if (coins[j] == 0 && g[j].size() == 1) {
                    q.offer(j);
                }
            }
            g[i].clear();
        }
        q.clear();
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                if (g[i].size() == 1) {
                    q.offer(i);
                }
            }
            for (int i : q) {
                for (int j : g[i]) {
                    g[j].remove(i);
                }
                g[i].clear();
            }
        }
        int ans = 0;
        for (var e : edges) {
            int a = e[0];
            int b = e[1];
            if (!g[a].isEmpty() && !g[b].isEmpty()) {
                ans += 2;
            }
        }
        return ans;
    }

}
