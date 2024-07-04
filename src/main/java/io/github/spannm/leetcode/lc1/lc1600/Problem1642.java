package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

class Problem1642 extends LeetcodeProblem {

    int furthestBuilding(int[] _heights, int _bricks, int _ladders) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;

        for (; i < _heights.length - 1 && minHeap.size() < _ladders; i++) {
            int diff = _heights[i + 1] - _heights[i];
            if (diff > 0) {
                minHeap.offer(diff);
            }
        }

        while (i < _heights.length - 1) {
            int diff = _heights[i + 1] - _heights[i];
            if (diff > 0) {

                if (!minHeap.isEmpty() && minHeap.peek() < diff) {
                    _bricks -= minHeap.poll();
                    minHeap.offer(diff);
                } else {
                    _bricks -= diff;
                }
                if (_bricks < 0) {
                    return i;
                }
            }
            i++;
        }
        return i;
    }

}
