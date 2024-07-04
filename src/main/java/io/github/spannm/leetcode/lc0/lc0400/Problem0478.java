package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0478 extends LeetcodeProblem {

    static class Solution {
        private final double radius;
        private final double xCenter;
        private final double yCenter;

        Solution(double _radius, double _xCenter, double _yCenter) {
            radius = _radius;
            xCenter = _xCenter;
            yCenter = _yCenter;
        }

        public double[] randPoint() {
            double len = Math.sqrt(Math.random()) * radius;
            double degree = Math.random() * 2 * Math.PI;
            double x = xCenter + len * Math.cos(degree);
            double y = yCenter + len * Math.sin(degree);
            return new double[] {x, y};
        }
    }

}
