package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/non-overlapping-intervals/">435. Non-overlapping Intervals</a>.
 */
class Problem0435 extends LeetcodeProblem {

    static int eraseOverlapIntervals(int[][] _intervals) {
        java.util.Arrays.sort(_intervals, Comparator.comparingInt(a -> a[1]));
        final int len = _intervals.length;
        int end = _intervals[0][1];
        int count = 1;

        for (int i = 1; i < len; i++) {
            int start = _intervals[i][0];
            if (start >= end) {
                end = _intervals[i][1];
                count++;
            }
        }
        return len - count;
    }

}
