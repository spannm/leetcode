package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

class Problem0252 extends LeetcodeProblem {

    boolean canAttendMeetings(int[][] _intervals) {
        if (_intervals == null || _intervals.length == 0) {
            return true;
        }
        Arrays.sort(_intervals, Comparator.comparingInt(a -> a[0]));
        int end = _intervals[0][1];
        for (int i = 1; i < _intervals.length; i++) {
            if (_intervals[i][0] < end) {
                return false;
            } else {
                end = _intervals[i][1];
            }
        }
        return true;
    }

}
