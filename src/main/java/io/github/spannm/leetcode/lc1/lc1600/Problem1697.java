package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/"> 1697. Checking Existence of
 * Edge Length Limited Paths</a>.
 */
class Problem1697 extends LeetcodeProblem {

    boolean[] distanceLimitedPathsExist(final int _n, final int[][] _edgeList, final int[][] _queries) {
        final int edgeLen = _edgeList.length;
        final int qLen = _queries.length;

        final int[] parents = new int[_n];
        for (int i = 0; i < _n; i++) {
            parents[i] = i;
        }

        // storing {u, v, weight, original idx} by increasing weight
        int[][] sortedQueries = new int[qLen][4];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i] = new int[] {_queries[i][0], _queries[i][1], _queries[i][2], i};
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[2]));

        // sort edgeList by increasing weight
        Arrays.sort(_edgeList, Comparator.comparingInt(a -> a[2]));
        int idx = 0;

        final boolean[] res = new boolean[qLen];

        for (int i = 0; i < qLen; i++) {
            int[] q = sortedQueries[i];
            int w = q[2];

            // union all edges with weight less than current query
            while (idx < edgeLen && _edgeList[idx][2] < w) {
                int[] e = _edgeList[idx++];
                int u = e[0];
                int v = e[1];
                union(parents, u, v);
            }

            int uQuery = q[0];
            int vQuery = q[1];
            int id = q[3];
            res[id] = find(parents, uQuery) == find(parents, vQuery);
        }

        return res;
    }

    static int find(int[] _parents, int _u) {
        while (_u != _parents[_u]) {
            _parents[_u] = _parents[_parents[_u]];
            _u = _parents[_u];
        }
        return _u;
    }

    static void union(int[] _parents, int _u, int _v) {
        int uParent = find(_parents, _u);
        int vParent = find(_parents, _v);
        _parents[uParent] = vParent;
    }

}
