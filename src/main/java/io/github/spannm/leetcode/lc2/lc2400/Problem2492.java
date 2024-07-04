package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/two-sum/">2492. Minimum Score of a Path Between Two Cities</a>.
 */
class Problem2492 extends LeetcodeProblem {

    int minScore(int _n, int[][] _roads) {

        final Map<Integer, Map<Integer, Integer>> graph = new LinkedHashMap<>();
        for (int[] road : _roads) {
            Integer u = road[0];
            Integer v = road[1];
            Integer w = road[2];
            graph.computeIfAbsent(u, k -> new LinkedHashMap<>()).put(v, w);
            graph.computeIfAbsent(v, k -> new LinkedHashMap<>()).put(u, w);
        }

        int res = Integer.MAX_VALUE;
        Set<Integer> seen = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        Integer node;
        while ((node = queue.poll()) != null) {
            for (Map.Entry<Integer, Integer> e : graph.get(node).entrySet()) {
                Integer adj = e.getKey();
                Integer score = e.getValue();
                if (!seen.contains(adj)) {
                    queue.offer(adj);
                    seen.add(adj);
                }
                res = Math.min(res, score);
            }
        }

        return res;
    }

}
