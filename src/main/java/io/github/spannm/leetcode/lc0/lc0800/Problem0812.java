package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0812 extends LeetcodeProblem {

    double largestTriangleArea(int[][] _points) {
        double largestArea = 0.0;
        for (int i = 0; i < _points.length - 2; i++) {
            for (int j = i + 1; j < _points.length - 1; j++) {
                for (int k = j + 1; k < _points.length; k++) {
                    double area = Math.abs(_points[i][0] * (_points[j][1] - _points[k][1]) + _points[j][0] * (_points[k][1] - _points[i][1]) + _points[k][0] * (_points[i][1] - _points[j][1])) / 2.0;
                    largestArea = Math.max(largestArea, area);

                }
            }
        }
        return largestArea;
    }

}
