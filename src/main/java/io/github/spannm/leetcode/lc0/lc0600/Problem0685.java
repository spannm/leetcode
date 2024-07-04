package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 685. Redundant Connection II.
 */
class Problem0685 extends LeetcodeProblem {

    int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        UnionFind uf = new UnionFind(n + 1);
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (p[v] != v) {
                conflict = i;
            } else {
                p[v] = u;
                if (!uf.union(u, v)) {
                    cycle = i;
                }
            }
        }
        if (conflict == -1) {
            return edges[cycle];
        }
        int v = edges[conflict][1];
        if (cycle != -1) {
            return new int[] {p[v], v};
        }
        return edges[conflict];
    }

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    static class UnionFind {
        int                 n;
        private final int[] p;

        UnionFind(int _n) {
            n = _n;
            p = new int[_n];
            for (int i = 0; i < _n; i++) {
                p[i] = i;
            }
        }

        boolean union(int _a, int _b) {
            int pa = find(_a);
            int pb = find(_b);
            if (pa == pb) {
                return false;
            }
            p[pa] = pb;
            n--;
            return true;
        }

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

    }

}
