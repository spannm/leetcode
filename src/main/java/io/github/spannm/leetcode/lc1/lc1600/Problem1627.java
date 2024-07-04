package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1627. Graph Connectivity With Threshold.
 */
class Problem1627 extends LeetcodeProblem {

    List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n + 1);
        for (int a = threshold + 1; a <= n; a++) {
            for (int b = a + a; b <= n; b += a) {
                uf.union(a, b);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (var q : queries) {
            ans.add(uf.find(q[0]) == uf.find(q[1]));
        }
        return ans;
    }

    static class UnionFind {
        private final int[] p;
        private final int[] size;

        UnionFind(int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) {
                return false;
            }
            if (size[pa] > size[pb]) {
                p[pb] = pa;
                size[pa] += size[pb];
            } else {
                p[pa] = pb;
                size[pb] += size[pa];
            }
            return true;
        }

    }
}
