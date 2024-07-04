package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1288. Remove Covered Intervals.
 */
class Problem1288 extends LeetcodeProblem {

    int removeCoveredIntervals(int[][] _intervals) {
        Arrays.sort(_intervals, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
        int[] pre = _intervals[0];
        int cnt = 1;
        for (int i = 1; i < _intervals.length; i++) {
            if (pre[1] < _intervals[i][1]) {
                cnt++;
                pre = _intervals[i];
            }
        }
        return cnt;
    }

}
