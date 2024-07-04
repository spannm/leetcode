package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1971 extends LeetcodeProblem {

    boolean validPath(int _n, int[][] _edges, int _start, int _end) {
        if (_start == _end) {
            return true;
        }
        Map<Integer, Set<Integer>> neighbors = new LinkedHashMap<>();
        for (int[] edge : _edges) {
            int u = edge[0];
            int v = edge[1];

            neighbors.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            neighbors.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedVertices = new HashSet<>();
        queue.offer(_start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curr = queue.poll();
                Set<Integer> set = neighbors.get(curr);
                if (set != null) {
                    for (int neighbor : set) {
                        if (neighbor == _end) {
                            return true;
                        } else if (visitedVertices.add(neighbor)) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return false;
    }

}
