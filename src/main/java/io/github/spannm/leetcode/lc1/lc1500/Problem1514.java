package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/path-with-maximum-probability/">1514. Path with Maximum Probability</a>.
 */
class Problem1514 extends LeetcodeProblem {

    static double maxProbability(int _n, int[][] _edges, double[] _succProb, int _start, int _end) {

        final Map<Integer, Map<Integer, Double>> g = new HashMap<>();
        for (int i = 0; i < _edges.length; i++) {
            int[] e = _edges[i];
            g.computeIfAbsent(e[0], m -> new HashMap<>()).put(e[1], _succProb[i]);
            g.computeIfAbsent(e[1], m -> new HashMap<>()).put(e[0], _succProb[i]);
        }
        Queue<double[]> q = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[0]));
        final double[] prob = new double[_n];
        q.offer(new double[] {1, _start});

        while (!q.isEmpty()) {
            double[] cur = q.poll();
            int v = (int) cur[1];

            if (v == _end) {
                return cur[0];
            }

            if (cur[0] > prob[v]) {
                prob[v] = cur[0];
                for (Map.Entry<Integer, Double> entry : g.getOrDefault(v, Map.of()).entrySet()) {
                    int nb = entry.getKey();
                    double p = entry.getValue();
                    q.offer(new double[] {cur[0] * p, nb});
                }
            }
        }
        return 0d;
    }

}
