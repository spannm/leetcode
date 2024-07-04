package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/"> 1579. Remove Max
 * Number of Edges to Keep Graph Fully Traversable</a>.
 */
class Problem1579 extends LeetcodeProblem {

    int maxNumEdgesToRemove(int _n, int[][] _edges) {
        int[] rootA = new int[_n + 1];
        int[] rootB = new int[_n + 1];
        for (int i = 1; i <= _n; i++) {
            rootA[i] = i;
            rootB[i] = i;
        }

        int res = 0;
        int aliceEdges = 0;
        int bobEdges = 0;

        for (int[] edge : _edges) {
            if (edge[0] != 3) {
                continue;
            } else if (union(edge[1], edge[2], rootA)) {
                aliceEdges++;
                if (union(edge[1], edge[2], rootB)) {
                    bobEdges++;
                }
            } else {
                res++;
            }
        }

        for (int[] edge : _edges) {
            if (edge[0] != 1) {
                continue;
            } else if (union(edge[1], edge[2], rootA)) {
                aliceEdges++;
            } else {
                res++;
            }
        }

        for (int[] edge : _edges) {
            if (edge[0] != 2) {
                continue;
            } else if (union(edge[1], edge[2], rootB)) {
                bobEdges++;
            } else {
                res++;
            }
        }

        return aliceEdges == bobEdges && aliceEdges == _n - 1 ? res : -1;
    }

    static boolean union(int _a, int _b, int[] _root) {
        int rootA = find(_a, _root);
        int rootB = find(_b, _root);
        if (rootA == rootB) {
            return false;
        }
        _root[rootA] = rootB;
        return true;
    }

    static int find(int _a, int[] _root) {
        if (_root[_a] != _a) {
            _root[_a] = find(_root[_a], _root);
        }
        return _root[_a];
    }

}
