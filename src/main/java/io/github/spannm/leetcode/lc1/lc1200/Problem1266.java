package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem1266 extends LeetcodeProblem {

    int minTimeToVisitAllPoints(int[][] _points) {
        return IntStream.range(0, _points.length - 1).map(i -> chebyshevDistance(_points[i], _points[i + 1])).sum();
    }

    static int chebyshevDistance(int[] _pA, int[] _pB) {
        return Math.max(Math.abs(_pA[0] - _pB[0]), Math.abs(_pA[1] - _pB[1]));
    }

}
