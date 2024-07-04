package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/design-graph-with-shortest-path-calculator/">2642. Design Graph With Shortest
 * Path Calculator</a>.
 */
class Problem2642 extends LeetcodeProblem {

    static final class Graph {

        private final List<List<int[]>> res;
        private final int               n;

        Graph(int _n, int[][] _edges) {
            n = _n;
            res = new ArrayList<>();

            IntStream.range(0, _n).forEach(i -> res.add(new ArrayList<>()));
            Arrays.stream(_edges).forEach(this::addEdge);
        }

        void addEdge(int[] _edge) {
            res.get(_edge[0]).add(new int[] {_edge[1], _edge[2]});
        }

        int shortestPath(int _node1, int _node2) {
            Queue<int[]> nm = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            nm.offer(new int[] {_node1, 0});
            boolean[] visited = new boolean[n];
            while (!nm.isEmpty()) {
                int[] curr = nm.poll();
                int u = curr[0];
                int d = curr[1];
                if (visited[u]) {
                    continue;
                }
                visited[u] = true;
                if (u == _node2) {
                    return d;
                }
                for (int[] e : res.get(u)) {
                    int v = e[0];
                    int w = e[1];
                    if (!visited[v]) {
                        nm.offer(new int[] {v, d + w});
                    }
                }
            }
            return -1;
        }
    }

}
