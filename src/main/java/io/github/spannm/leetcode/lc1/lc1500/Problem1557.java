package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">1557. Minimum Number of
 * Vertices to Reach All Nodes</a>.
 */
class Problem1557 extends LeetcodeProblem {

    static List<Integer> findSmallestSetOfVertices(final int _count, final List<List<Integer>> _edges) {
        // calculate degree (or valency) of each vertex in the graph (number of edges that are incident to the vertex)
        final int[] degree = new int[_count];
        _edges.stream().map(e -> e.get(1)).forEach(i -> degree[i]++);

        // return list of unreachable vertices
        return IntStream.range(0, _count).filter(i -> degree[i] == 0).boxed().toList();
    }

}
