package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem1094 extends LeetcodeProblem {

    boolean carPooling(int[][] _trips, int _capacity) {
        Arrays.sort(_trips, Comparator.comparingInt(a -> a[1]));
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] trip : _trips) {
            int startTime = trip[1];
            int endTime = trip[2];
            while (!heap.isEmpty() && heap.peek()[1] <= startTime) {
                int[] curr = heap.poll();
                _capacity += curr[0];
            }
            int peopleCnt = trip[0];
            _capacity -= peopleCnt;
            if (_capacity < 0) {
                return false;
            }
            heap.offer(new int[] {peopleCnt, endTime});
        }
        return true;
    }

}
