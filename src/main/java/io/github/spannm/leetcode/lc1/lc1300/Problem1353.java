package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem1353 extends LeetcodeProblem {

    int maxEvents(int[][] _events) {
        Arrays.sort(_events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Queue<Integer> heap = new PriorityQueue<>();
        int maxEvents = 0;
        int i = 0;
        for (int day = 1; day <= 100000; day++) {
            while (i < _events.length && _events[i][0] == day) {
                heap.offer(_events[i++][1]);
            }
            while (!heap.isEmpty() && heap.peek() < day) {
                heap.poll();
            }
            if (!heap.isEmpty()) {
                heap.poll();
                maxEvents++;
            }
        }
        return maxEvents;
    }

}
