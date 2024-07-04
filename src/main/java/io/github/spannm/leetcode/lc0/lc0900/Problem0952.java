package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 952. Largest Component Size by Common Factor.
 */
class Problem0952 extends LeetcodeProblem {

    int largestComponentSize(int[] _nums) {
        int m = 0;
        for (int v : _nums) {
            m = Math.max(m, v);
        }
        UnionFind uf = new UnionFind(m + 1);
        for (int v : _nums) {
            int i = 2;
            while (i <= v / i) {
                if (v % i == 0) {
                    uf.union(v, i);
                    uf.union(v, v / i);
                }
                i++;
            }
        }
        int[] cnt = new int[m + 1];
        int ans = 0;
        for (int v : _nums) {
            int t = uf.find(v);
            cnt[t]++;
            ans = Math.max(ans, cnt[t]);
        }
        return ans;
    }

    static class UnionFind {
        private final int[] p;

        UnionFind(int _n) {
            p = new int[_n];
            for (int i = 0; i < _n; i++) {
                p[i] = i;
            }
        }

        void union(int _a, int _b) {
            int pa = find(_a);
            int pb = find(_b);
            if (pa != pb) {
                p[pa] = pb;
            }
        }

        int find(int _x) {
            if (p[_x] != _x) {
                p[_x] = find(p[_x]);
            }
            return p[_x];
        }

    }

}
