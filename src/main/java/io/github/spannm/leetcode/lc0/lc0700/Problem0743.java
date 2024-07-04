package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0743 extends LeetcodeProblem {

    static final int MAX = 100_00_00;

    private int[][] parseTimes(int[][] _times, int _n) {
        int[][] weights = new int[_n + 1][_n + 1];

        for (int i = 0; i < _n + 1; i++) {
            for (int j = 0; j < _n + 1; j++) {
                weights[i][j] = MAX;
            }
        }

        for (int[] time : _times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            weights[u][v] = w;
        }

        return weights;
    }

    private int findMinUnvisitedIndex(int[] _a, boolean[] _visited) {
        int min = Integer.MAX_VALUE;
        int minIdx = 1;

        for (int i = 1; i < _a.length; i++) {
            if (_a[i] < min && !_visited[i]) {
                min = _a[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    int networkDelayTime(int[][] _times, int _n, int _k) {

        int[][] weights = parseTimes(_times, _n);

        int[] totalTime = new int[_n + 1];
        for (int j = 0; j <= _n; j++) {
            totalTime[j] = MAX;
        }
        totalTime[_k] = 0;

        boolean[] visited = new boolean[_n + 1];
        int visitCount = 0;

        while (visitCount != _n) {
            int node = findMinUnvisitedIndex(totalTime, visited);

            if (totalTime[node] >= MAX) {
                return -1;
            }

            visited[node] = true;
            visitCount += 1;

            for (int i = 1; i <= _n; i++) {
                totalTime[i] = Math.min(weights[node][i] + totalTime[node], totalTime[i]);
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for (int k = 1; k <= _n; k++) {
            maxVal = Math.max(totalTime[k], maxVal);
        }

        return maxVal;
    }

}
