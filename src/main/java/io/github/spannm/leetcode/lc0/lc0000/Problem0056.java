package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/">56. Merge Intervals</a>.
 */
class Problem0056 extends LeetcodeProblem {

    int[][] merge(int[][] _intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(_intervals, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1])); // to
                                                                                                                     // avoid
                                                                                                                     // integer
                                                                                                                     // subtraction
                                                                                                                     // overflow
        for (int i = 0; i < _intervals.length; i++) {
            int start = _intervals[i][0];
            int end = _intervals[i][1];
            while (i + 1 < _intervals.length && _intervals[i + 1][0] <= end) {
                end = Math.max(_intervals[i + 1][1], end);
                i++;
            }
            list.add(new int[] {start, end});
        }
        int[][] arr = list.toArray(new int[list.size()][2]);
        _intervals = null;
        list = null;
        return arr;
    }

}
