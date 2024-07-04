package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0699 extends LeetcodeProblem {

    List<Integer> fallingSquares(int[][] _positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int height = 0;
        for (int[] position : _positions) {
            Interval curr = new Interval(position[0], position[0] + position[1] - 1, position[1]);
            height = Math.max(height, getHeight(intervals, curr));
            result.add(height);
        }
        return result;
    }

    private int getHeight(List<Interval> _intervals, Interval _curr) {
        int preMaxHeight = 0;
        for (Interval interval : _intervals) {
            if (interval.end < _curr.start || interval.start > _curr.end) {
                continue;
            }
            preMaxHeight = Math.max(preMaxHeight, interval.height);
        }
        _curr.height += preMaxHeight;
        _intervals.add(_curr);
        return _curr.height;
    }

    static class Interval {
        private final int start;
        private final int end;
        private int       height;

        Interval(int _start, int _end, int _height) {
            start = _start;
            end = _end;
            height = _height;
        }
    }

}
