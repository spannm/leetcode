package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem1705 extends LeetcodeProblem {

    int eatenApples(int[] _apples, int[] _days) {
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int eatenApples = 0;
        for (int i = 0; i < _apples.length || !minHeap.isEmpty(); i++) {
            if (i < _apples.length) {
                minHeap.offer(new int[] {i + _days[i], _apples[i]});
            }
            while (!minHeap.isEmpty() && (minHeap.peek()[0] <= i || minHeap.peek()[1] <= 0)) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                eatenApples++;
                minHeap.peek()[1]--;
            }
        }
        return eatenApples;
    }

}
