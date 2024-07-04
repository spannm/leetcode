package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0573 extends LeetcodeProblem {

    int minDistance(int _height, int _width, int[] _tree, int[] _squirrel, int[][] _nuts) {
        int totalDist = 0;
        int savedDist = Integer.MIN_VALUE;
        for (int[] nut : _nuts) {
            totalDist += getDist(nut, _tree) * 2;
            savedDist = Math.max(savedDist, getDist(nut, _tree) - getDist(nut, _squirrel));
        }
        return totalDist - savedDist;
    }

    private int getDist(int[] _pointA, int[] _pointB) {
        return Math.abs(_pointA[0] - _pointB[0]) + Math.abs(_pointA[1] - _pointB[1]);
    }

}
