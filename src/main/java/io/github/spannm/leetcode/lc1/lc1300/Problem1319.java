package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/"> 1319. Number of Operations
 * to Make Network Connected</a>.
 */
class Problem1319 extends LeetcodeProblem {

    int makeConnected(int _n, int[][] _connections) {
        if (_connections.length < _n - 1) {
            return -1;
        }
        List<List<Integer>> graph = new ArrayList<>(_n);
        for (int i = 0; i < _n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] c : _connections) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }

        int compos = 0;
        boolean[] visited = new boolean[_n];
        for (int v = 0; v < _n; v++) {
            compos += dfs(v, graph, visited);
        }
        return compos - 1;
    }

    static int dfs(int _idx, List<List<Integer>> _graph, boolean[] _visited) {
        if (_visited[_idx]) {
            return 0;
        }
        _visited[_idx] = true;
        for (int v : _graph.get(_idx)) {
            dfs(v, _graph, _visited);
        }
        return 1;
    }

}
