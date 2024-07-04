package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

class Problem1792 extends LeetcodeProblem {

    double maxAverageRatio(int[][] _classes, int _extraStudents) {
        Queue<double[]> maxHeap = new PriorityQueue<>((a, b) -> -Double.compare(a[0], b[0]));
        for (int[] c : _classes) {
            maxHeap.offer(new double[] {(double) (c[0] + 1) / (c[1] + 1) - (double) c[0] / c[1], c[0], c[1]});
        }
        while (_extraStudents-- > 0) {
            double[] curr = maxHeap.poll();
            curr[1]++;
            curr[2]++;
            curr[0] = (curr[1] + 1) / (curr[2] + 1) - curr[1] / curr[2];
            maxHeap.offer(curr);
        }
        double result = 0.0;
        int size = maxHeap.size();
        while (!maxHeap.isEmpty()) {
            double[] curr = maxHeap.poll();
            result += curr[1] / curr[2];
        }
        return result / size;
    }

}
