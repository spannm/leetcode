package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1037 extends LeetcodeProblem {

    boolean isBoomerang(int[][] _points) {
        return (_points[1][1] - _points[0][1]) * (_points[2][0] - _points[0][0]) != (_points[2][1] - _points[0][1]) * (_points[1][0] - _points[0][0]);
    }

}
