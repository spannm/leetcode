package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem1377 extends LeetcodeProblem {

    double frogPosition(int _n, int[][] _edges, int _t, int _target) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[_n];
        for (int i = 0; i < _n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : _edges) {
            graph[edge[0] - 1].add(edge[1] - 1);
            graph[edge[1] - 1].add(edge[0] - 1);
        }
        boolean[] visited = new boolean[_n];
        visited[0] = true;
        double[] probabilities = new double[_n];
        probabilities[0] = 1f;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty() && _t-- > 0) {
            for (int i = queue.size(); i > 0; i--) {
                int vertex = queue.poll();
                int nextVerticesCount = 0;
                for (int next : graph[vertex]) {
                    if (!visited[next]) {
                        nextVerticesCount++;
                    }
                }
                for (int next : graph[vertex]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                        probabilities[next] = probabilities[vertex] / nextVerticesCount;
                    }
                }
                if (nextVerticesCount > 0) {
                    probabilities[vertex] = 0;
                }
            }
        }
        return probabilities[_target - 1];
    }

}
