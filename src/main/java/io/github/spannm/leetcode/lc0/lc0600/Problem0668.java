package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem0668 extends LeetcodeProblem {

    int findKthNumber(int _m, int _n, int _k) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 1; i <= _m; i++) {
            for (int j = 1; j <= _n; j++) {
                minHeap.offer(i * j);
            }
        }
        while (_k-- > 1) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

}
