package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0495 extends LeetcodeProblem {

    int findPoisonedDuration(int[] _timeSeries, int _dur) {
        if (_timeSeries == null || _timeSeries.length == 0 || _dur == 0) {
            return 0;
        }
        int totalDur = 0;
        for (int i = 0; i < _timeSeries.length - 1; i++) {
            totalDur += Math.min(_timeSeries[i + 1] - _timeSeries[i], _dur);
        }
        totalDur += _dur;
        return totalDur;
    }

}
