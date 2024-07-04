package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1450 extends LeetcodeProblem {

    int busyStudent(int[] _startTime, int[] _endTime, int _queryTime) {
        int count = 0;
        for (int i = 0; i < _startTime.length; i++) {
            if (_startTime[i] <= _queryTime && _endTime[i] >= _queryTime) {
                count++;
            }
        }
        return count;
    }

}
