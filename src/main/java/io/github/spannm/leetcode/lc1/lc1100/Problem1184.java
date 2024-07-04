package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1184 extends LeetcodeProblem {

    int distanceBetweenBusStops(int[] _distance, int _start, int _destination) {
        if (_start > _destination) {
            int tmp = _start;
            _start = _destination;
            _destination = tmp;
        }
        int clockwise = 0;
        for (int i = _start; i < _destination; i++) {
            clockwise += _distance[i];
        }
        int counterClockwise = 0;
        for (int i = _destination; i < _distance.length; i++) {
            counterClockwise += _distance[i];
        }
        for (int i = 0; i < _start; i++) {
            counterClockwise += _distance[i];
        }

        return Math.min(clockwise, counterClockwise);
    }

}
