package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 */
class Problem0452 extends LeetcodeProblem {

    int findMinArrowShots(int[][] _points) {
        int len = _points.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return 1;
        } else {
            Arrays.sort(_points, Comparator.comparing(arr -> arr[1]));
            int arrowPos = _points[0][1];
            int count = 1;
            for (int i = 1; i < len; i++) {
                if (arrowPos < _points[i][0]) {
                    count++;
                    arrowPos = _points[i][1];
                }
            }
            return count;
        }
    }

}
