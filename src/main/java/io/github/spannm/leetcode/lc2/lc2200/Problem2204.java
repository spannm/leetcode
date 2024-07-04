package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2204. Distance to a Cycle in Undirected Graph.
 */
class Problem2204 extends LeetcodeProblem {

    int[] distanceToCycle(int n, int[][] edges) {
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
            if (g[i].size() == 1) {
                q.offer(i);
            }
        }
        int[] f = new int[n];
        Deque<Integer> seq = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int i = q.poll();
            seq.push(i);
            for (int j : g[i]) {
                g[j].remove(i);
                f[i] = j;
                if (g[j].size() == 1) {
                    q.offer(j);
                }
            }
        }
        int[] ans = new int[n];
        while (!seq.isEmpty()) {
            int i = seq.pop();
            ans[i] = ans[f[i]] + 1;
        }
        return ans;
    }

}
