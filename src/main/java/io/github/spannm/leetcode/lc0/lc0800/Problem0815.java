package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/bus-routes/">815. Bus Routes</a>.
 */
class Problem0815 extends LeetcodeProblem {

    int numBusesToDestination(int[][] _routes, int _source, int _target) {
        if (_source == _target) {
            return 0;
        }
        int nbRoutes = _routes.length;
        @SuppressWarnings("unchecked")
        Set<Integer>[] s = new Set[nbRoutes];
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[nbRoutes];
        Arrays.setAll(s, k -> new HashSet<>());
        Arrays.setAll(g, k -> new ArrayList<>());
        Map<Integer, List<Integer>> d = new HashMap<>();
        for (int i = 0; i < nbRoutes; i++) {
            for (int v : _routes[i]) {
                s[i].add(v);
                d.computeIfAbsent(v, k -> new ArrayList<>()).add(i);
            }
        }
        for (var ids : d.values()) {
            int m = ids.size();
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    int a = ids.get(i);
                    int b = ids.get(j);
                    g[a].add(b);
                    g[b].add(a);
                }
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>();
        int ans = 1;
        for (int v : d.get(_source)) {
            q.offer(v);
            vis.add(v);
        }
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                int i = q.pollFirst();
                if (s[i].contains(_target)) {
                    return ans;
                }
                for (int j : g[i]) {
                    if (!vis.contains(j)) {
                        vis.add(j);
                        q.offer(j);
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}
