package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

class Problem1724 extends LeetcodeProblem {

    static class PersistentUnionFind {
        private final int   inf = 1 << 30;
        private final int[] rank;
        private final int[] parent;
        private final int[] version;

        PersistentUnionFind(int _n) {
            rank = new int[_n];
            parent = new int[_n];
            version = new int[_n];
            for (int i = 0; i < _n; i++) {
                parent[i] = i;
                version[i] = inf;
            }
        }

        int find(int _x, int _t) {
            return parent[_x] == _x || version[_x] >= _t ? _x : find(parent[_x], _t);
        }

        boolean union(int _a, int _b, int _t) {
            int pa = find(_a, inf);
            int pb = find(_b, inf);
            if (pa == pb) {
                return false;
            }
            if (rank[pa] > rank[pb]) {
                version[pb] = _t;
                parent[pb] = pa;
            } else {
                version[pa] = _t;
                parent[pa] = pb;
                if (rank[pa] == rank[pb]) {
                    rank[pb]++;
                }
            }
            return true;
        }

    }

    static class DistanceLimitedPathsExist {
        private final PersistentUnionFind puf;

        DistanceLimitedPathsExist(int _n, int[][] _edgeList) {
            puf = new PersistentUnionFind(_n);
            Arrays.sort(_edgeList, Comparator.comparingInt(a -> a[2]));
            for (var e : _edgeList) {
                puf.union(e[0], e[1], e[2]);
            }
        }

        boolean query(int _p, int _q, int _limit) {
            return puf.find(_p, _limit) == puf.find(_q, _limit);
        }

    }

}
