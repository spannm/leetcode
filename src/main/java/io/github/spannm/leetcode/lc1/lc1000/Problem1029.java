package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1029 extends LeetcodeProblem {

    int twoCitySchedCost(int[][] _costs) {
        Arrays.sort(_costs, (a, b) -> (a[0] - a[1] - (b[0] - b[1])));
        int cost = 0;
        for (int i = 0; i < _costs.length; i++) {
            if (i < _costs.length / 2) {
                cost += _costs[i][0];
            } else {
                cost += _costs[i][1];
            }
        }
        return cost;
    }

}
