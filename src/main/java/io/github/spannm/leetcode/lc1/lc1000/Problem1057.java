package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1057 extends LeetcodeProblem {

    int[] assignBikes(final int[][] _workers, final int[][] _bikes) {
        int w = _workers.length;
        int b = _bikes.length;
        Map<Integer, Queue<int[]>> map = new TreeMap<>();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < b; j++) {
                int distance = Math.abs(_workers[i][0] - _bikes[j][0]) + Math.abs(_workers[i][1] - _bikes[j][1]);
                map.computeIfAbsent(distance, k -> new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]))
                    .add(new int[] {i, j});
            }
        }
        int[] ans = new int[w];
        Arrays.fill(ans, -1);
        boolean[] assigned = new boolean[b];
        int workersHaveBikes = 0;
        for (int dist : map.keySet()) {
            Queue<int[]> workerBikePairs = map.get(dist);
            while (!workerBikePairs.isEmpty()) {
                int[] workerBikePair = workerBikePairs.poll();
                if (ans[workerBikePair[0]] == -1 && !assigned[workerBikePair[1]]) {
                    assigned[workerBikePair[1]] = true;
                    ans[workerBikePair[0]] = workerBikePair[1];
                    workersHaveBikes++;
                }
            }
            if (workersHaveBikes == w) {
                return ans;
            }
        }
        return ans;
    }

}
