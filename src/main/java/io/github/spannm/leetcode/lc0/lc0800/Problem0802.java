package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/">802. Find Eventual Safe States</a>.
 */
class Problem0802 extends LeetcodeProblem {

    private static final byte UNKNOWN = 0;
    private static final byte UNSAFE  = 1;
    private static final byte SAFE    = -1;

    static List<Integer> eventualSafeNodes(final int[][] _graph) {
        final byte[] states = new byte[_graph.length]; // contains UNKNOWN (0) by default

        return IntStream.range(0, _graph.length)
            .filter(node -> isSafeNode(_graph, node, states))
            .boxed()
            .toList();
    }

    private static boolean isSafeNode(final int[][] _graph, final int _node, final byte[] _states) {
        if (UNKNOWN != _states[_node]) {
            return SAFE == _states[_node];
        }

        _states[_node] = UNSAFE;

        for (int nextNode : _graph[_node]) {
            if (!isSafeNode(_graph, nextNode, _states)) {
                return false;
            }
        }

        _states[_node] = SAFE;
        return true;
    }

}
