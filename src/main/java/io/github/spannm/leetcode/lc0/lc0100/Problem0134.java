package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/gas-station/">134. Gas Station</a>.
 */
class Problem0134 extends LeetcodeProblem {

    @SuppressWarnings("PMD.LinguisticNaming")
    int canCompleteCircuit(int[] _gas, int[] _cost) {
        int len = _gas.length;
        int tank = 0;
        for (int g = 0; g < len; g++) {
            tank += _gas[g] - _cost[g];
        }
        if (tank < 0) {
            return -1;
        }

        int start = 0;
        int accumulate = 0;
        for (int g = 0; g < len; g++) {
            int currGain = _gas[g] - _cost[g];
            if (accumulate + currGain < 0) {
                start = g + 1;
                accumulate = 0;
            } else {
                accumulate += currGain;
            }
        }

        return start;
    }

}
