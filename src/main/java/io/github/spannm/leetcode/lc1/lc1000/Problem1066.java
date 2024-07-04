package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1066 extends LeetcodeProblem {
    private int minSum = Integer.MAX_VALUE;

    int assignBikes(int[][] _workers, int[][] _bikes) {
        backtracking(_workers, _bikes, 0, new boolean[_bikes.length], 0);
        return minSum;
    }

    private void backtracking(int[][] _workers, int[][] _bikes, int _workersIndex, boolean[] _bikesAssigned, int _currentSum) {
        if (_workersIndex >= _workers.length) {
            minSum = Math.min(minSum, _currentSum);
            return;
        }

        if (_currentSum > minSum) {
            return;
        }

        for (int j = 0; j < _bikes.length; j++) {
            if (!_bikesAssigned[j]) {
                _bikesAssigned[j] = true;
                backtracking(_workers, _bikes, _workersIndex + 1, _bikesAssigned, _currentSum + dist(_workers[_workersIndex], _bikes[j]));
                _bikesAssigned[j] = false;
            }
        }
    }

    private int dist(int[] _worker, int[] _bike) {
        return Math.abs(_worker[0] - _bike[0]) + Math.abs(_worker[1] - _bike[1]);
    }

}
