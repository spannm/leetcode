package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0447 extends LeetcodeProblem {

    int numberOfBoomerangs(int[][] _points) {
        if (_points == null || _points.length == 0 || _points[0].length == 0) {
            return 0;
        }
        int result = 0;
        int totalPts = _points.length;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < totalPts; i++) {
            for (int j = 0; j < totalPts; j++) {
                if (i == j) {
                    continue;
                }
                long d = calcDistance(_points[i], _points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            for (int val : map.values()) {
                result += val * (val - 1);
            }
            map.clear();
        }
        return result;
    }

    static long calcDistance(int[] _p1, int[] _p2) {
        long x = _p2[0] - _p1[0];
        long y = _p2[1] - _p1[1];
        return x * x + y * y;
    }

}
