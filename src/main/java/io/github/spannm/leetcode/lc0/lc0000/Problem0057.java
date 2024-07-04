package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/insert-interval/">57. Insert Interval</a>.
 */
class Problem0057 extends LeetcodeProblem {

    int[][] insert(int[][] _intervals, int[] _newInterval) {

        int arrLen = _intervals == null ? 0 : _intervals.length;
        if (arrLen == 0) {
            return new int[][] {_newInterval};
        }

        // if start of new interval greater max right point, add at end
        if (_newInterval[0] > _intervals[arrLen - 1][1]) {
            _intervals = Arrays.copyOf(_intervals, arrLen + 1);
            _intervals[arrLen] = _newInterval;
            return _intervals;
        }

        // if end of new interval smaller max left point, add at front
        if (_newInterval[1] < _intervals[0][0]) {
            int[][] newIntervals = new int[arrLen + 1][];
            newIntervals[0] = _newInterval;
            System.arraycopy(_intervals, 0, newIntervals, 1, arrLen);
            return newIntervals;
        }

        List<int[]> intervalList = new ArrayList<>();

        int[] mergeInterval = null;
        for (int i = 0; i < arrLen; i++) {
            int[] currInterval = _intervals[i];

            if (_newInterval[0] >= currInterval[0] && _newInterval[1] <= currInterval[1]) { // within
                return _intervals;
            }

            if (mergeInterval == null && currInterval[1] < _newInterval[0]) {
                // no overlap with current
                intervalList.add(currInterval);

                // no overlap with next
                if (i < arrLen - 1 && _newInterval[1] < _intervals[i + 1][0]) {
                    intervalList.add(_newInterval);
                    intervalList.addAll(List.of(_intervals).subList(i + 1, arrLen));
                    break;
                }
            } else if (mergeInterval != null) { // currently merging
                if (mergeInterval[1] < currInterval[0]) {
                    intervalList.add(mergeInterval);
                    intervalList.addAll(List.of(_intervals).subList(i, arrLen));
                    break;
                } else if (i == arrLen - 1) { // last
                    mergeInterval[1] = Math.max(mergeInterval[1], currInterval[1]);
                    intervalList.add(mergeInterval);
                    break;
                } else {
                    mergeInterval[1] = Math.max(mergeInterval[1], currInterval[1]);
                }

            } else {
                mergeInterval = new int[] {Math.min(currInterval[0], _newInterval[0]), Math.max(currInterval[1], _newInterval[1])
                };
                if (i == arrLen - 1) { // last
                    intervalList.add(mergeInterval);
                    break;
                }
            }

        }
        _intervals = intervalList.toArray(new int[0][]);
        return _intervals;
    }

}
