package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem0253 extends LeetcodeProblem {

    int minMeetingRooms(int[][] _intervals) {
        if (_intervals == null || _intervals.length == 0) {
            return 0;
        }

        Arrays.sort(_intervals, Comparator.comparingInt(a -> a[0]));

        Queue<int[]> heap = new PriorityQueue<>(_intervals.length, Comparator.comparingInt(a -> a[1]));
        heap.offer(_intervals[0]);

        for (int i = 1; i < _intervals.length; i++) {
            int[] interval = heap.poll();

            if (_intervals[i][0] >= interval[1]) {
                interval[1] = _intervals[i][1];
            } else {
                heap.offer(_intervals[i]);
            }

            heap.offer(interval);
        }

        return heap.size();
    }

}
