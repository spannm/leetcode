package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0684 extends LeetcodeProblem {

    static class UnionFind {
        private final int[]        ids;
        private final Set<Integer> visitedNodes;
        private int[]              redundantConn;

        UnionFind(int[][] _edges) {
            int len = _edges[0].length;
            Set<Integer> nodes = new HashSet<>();
            visitedNodes = new HashSet<>();
            redundantConn = new int[] {};
            for (int[] edge : _edges) {
                for (int j = 0; j < len; j++) {
                    nodes.add(edge[j]);
                }
            }
            ids = new int[nodes.size()];
            for (int i = 0; i < ids.length; i++) {
                ids[i] = i + 1;
            }
        }

        public int[] union(int[] _edge) {
            int x = find(_edge[0] - 1);
            int y = find(_edge[1] - 1);

            if (x == y && visitedNodes.contains(_edge[0]) && visitedNodes.contains(_edge[1])) {
                redundantConn = _edge;
            }

            if (x != y) {
                if (x < y) {
                    ids[y] = x + 1;
                } else {
                    ids[x] = y + 1;
                }
            }

            visitedNodes.add(_edge[0]);
            visitedNodes.add(_edge[1]);
            return redundantConn;
        }

        private int find(int _id) {
            if (isTree()) {
                return ids[_id];
            } else if (_id + 1 != ids[_id]) {
                return find(ids[_id] - 1);
            }
            return _id;
        }

        private boolean isTree() {
            Set<Integer> set = new HashSet<>();
            for (int i : ids) {
                set.add(i);
            }
            return set.size() == 1;
        }
    }

    int[] findRedundantConnection(int[][] _edges) {
        UnionFind unionFind = new UnionFind(_edges);
        int[] result = new int[] {};
        for (int[] edge : _edges) {
            result = unionFind.union(edge);
        }
        return result;
    }

}
