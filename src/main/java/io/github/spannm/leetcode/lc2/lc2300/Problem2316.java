package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/">2316. Count
 * Unreachable Pairs of Nodes in an Undirected Graph</a>.
 */
class Problem2316 extends LeetcodeProblem {

    long countPairs(int _nodeCount, int[][] _edges) {

        @SuppressWarnings("unchecked")
        final List<Integer>[] graph = new List[_nodeCount];
        for (int n = 0; n < _nodeCount; n++) {
            graph[n] = new ArrayList<>();
        }
        for (int[] edge : _edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        final boolean[] visited = new boolean[_nodeCount];
        long sum = (long) _nodeCount * (_nodeCount - 1) / 2;

        for (int i = 0; i < _nodeCount; i++) {
            if (!visited[i]) {
                int cnt = depthFirstSearch(graph, i, visited, new int[1]);
                if (cnt == 0) {
                    continue;
                }
                sum -= (long) cnt * (cnt - 1) / 2;
            }
        }
        return sum;
    }

    static int depthFirstSearch(List<Integer>[] _graph, int _node, boolean[] _visited, int[] _counts) {
        if (_visited[_node]) {
            return _counts[0];
        }
        _visited[_node] = true;
        _counts[0]++;
        for (int connection : _graph[_node]) {
            depthFirstSearch(_graph, connection, _visited, _counts);
        }
        return _counts[0];
    }

}
