package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 2192. All Ancestors of a Node in a Directed Acyclic Graph.
 */
class Problem2192 extends LeetcodeProblem {

    List<List<Integer>> getAncestors(int _n, int[][] _edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[_n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] e : _edges) {
            graph[e[0]].add(e[1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        IntStream.range(0, _n).forEach(i -> result.add(new ArrayList<>()));
        IntStream.range(0, _n).forEach(i -> bfs(i, graph, result));
        return result;
    }

    static void bfs(int _s, List<Integer>[] _graph, List<List<Integer>> _result) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(_s);
        boolean[] visited = new boolean[_result.size()];
        visited[_s] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : _graph[i]) {
                if (!visited[j]) {
                    visited[j] = true;
                    q.offer(j);
                    _result.get(j).add(_s);
                }
            }
        }
    }

}
