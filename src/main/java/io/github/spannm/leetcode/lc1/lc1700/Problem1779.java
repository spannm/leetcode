package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1779 extends LeetcodeProblem {

    int nearestValidPoint(int _x, int _y, int[][] _points) {
        int nearestManDistance = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < _points.length; i++) {
            int[] point = _points[i];
            if (point[0] == _x || point[1] == _y) {
                int distance = Math.abs(point[0] - _x) + Math.abs(point[1] - _y);
                if (distance < nearestManDistance) {
                    result = i;
                    nearestManDistance = distance;
                }
            }
        }
        return result;
    }

}
