package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem0973 extends LeetcodeProblem {

    int[][] kClosest(int[][] _points, int _k) {
        int[][] ans = new int[_k][2];
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(Problem0973::getDistance));
        pq.addAll(List.of(_points));

        for (int i = 0; i < _k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }

    static double getDistance(int[] _point) {
        return Math.sqrt(Math.pow(_point[0], 2) + Math.pow(_point[1], 2));
    }

}
