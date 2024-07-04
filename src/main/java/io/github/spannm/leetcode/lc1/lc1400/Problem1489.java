package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/">1489. Find
 * Critical and Pseudo-Critical Edges in Minimum Spanning Tree</a>.
 */
class Problem1489 extends LeetcodeProblem {

    List<List<Integer>> findCriticalAndPseudoCriticalEdges(int _n, int[][] _inedges) {
        int[][] edges = new int[_inedges.length][4];

        for (int i = 0; i < edges.length; i++) {
            edges[i][0] = _inedges[i][0];
            edges[i][1] = _inedges[i][1];
            edges[i][2] = _inedges[i][2];
            edges[i][3] = i;
        }

        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        int min = calcCost(_n, edges, null, null);

        List<Integer> criticals = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int[] edge : edges) {
            int costWithoutEdge = calcCost(_n, edges, null, edge);
            if (costWithoutEdge != min) {
                criticals.add(edge[3]);
            } else if (costWithoutEdge == min) {
                if (calcCost(_n, edges, edge, null) == min) {
                    pseudo.add(edge[3]);
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(criticals);
        answer.add(pseudo);

        _inedges = null;
        edges = null;
        criticals = null;
        pseudo = null;
        System.gc();

        return answer;
    }

    static int calcCost(int _n, int[][] _edges, int[] _pick, int[] _skip) {
        final UnionFind unionFind = new UnionFind(_n);
        int cost = 0;

        if (_pick != null) {
            cost += _pick[2];
            unionFind.union(_pick[0], _pick[1]);
        }

        for (int[] edge : _edges) {
            if (_skip != null && edge[0] == _skip[0] && edge[1] == _skip[1]) {
                continue;
            } else if (unionFind.find(edge[0]) == unionFind.find(edge[1])) {
                continue;
            }
            unionFind.union(edge[0], edge[1]);
            cost += edge[2];
            if (unionFind.getCount() == 1) {
                break;
            }
        }
        return cost;
    }

    static final class UnionFind {
        private final int[] root;
        private int         count;

        UnionFind(int _size) {
            root = new int[_size];
            count = _size;
            for (int i = 0; i < _size; i++) {
                root[i] = i;
            }
        }

        int getCount() {
            return count;
        }

        public int find(int _arg) {
            if (root[_arg] == _arg) {
                return _arg;
            }
            return root[_arg] = find(root[_arg]);
        }

        public void union(int _x, int _y) {
            int rootX = find(_x);
            int rootY = find(_y);
            if (rootX != rootY) {
                root[rootX] = rootY;
                count--;
            }
        }
    }

}
