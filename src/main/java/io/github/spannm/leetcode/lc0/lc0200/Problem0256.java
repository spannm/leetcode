package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0256 extends LeetcodeProblem {

    int minCost(int[][] _costs) {
        if (_costs == null || _costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < _costs.length; i++) {
            _costs[i][0] += Math.min(_costs[i - 1][1], _costs[i - 1][2]);
            _costs[i][1] += Math.min(_costs[i - 1][0], _costs[i - 1][2]);
            _costs[i][2] += Math.min(_costs[i - 1][1], _costs[i - 1][0]);
        }
        int n = _costs.length - 1;
        return Math.min(Math.min(_costs[n][0], _costs[n][1]), _costs[n][2]);
    }

}
