package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/is-graph-bipartite/">785. Is Graph Bipartite?</a>.
 */
class Problem0785 extends LeetcodeProblem {

    static boolean isBipartite(int[][] _graph) {
        final int len = _graph.length;
        final int[] colors = new int[len];
        Arrays.fill(colors, -1);

        for (int i = 0; i < len; i++) {
            if (colors[i] == -1 && !bfs(i, _graph, colors)) {
                return false;
            }
        }

        return true;
    }

    static boolean bfs(final int _node, final int[][] _graph, final int[] _colors) {
        _colors[_node] = 0;

        final Deque<Integer> q = new ArrayDeque<>();
        q.add(_node);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int neighbor : _graph[curr]) {
                if (_colors[neighbor] == _colors[curr]) {
                    return false;
                } else if (_colors[neighbor] == -1) {
                    _colors[neighbor] = 1 - _colors[curr];
                    q.add(neighbor);
                }
            }
        }

        return true;
    }

}
