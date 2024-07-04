package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

class Problem1686 extends LeetcodeProblem {

    int stoneGameVI(int[] _aliceValues, int[] _bobValues) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : b[0] - a[0]);
        for (int i = 0; i < _aliceValues.length; i++) {
            maxHeap.offer(new int[] {_aliceValues[i] + _bobValues[i], i});
        }
        int[] sums = new int[_aliceValues.length];
        boolean aliceTurn = true;
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            if (aliceTurn) {
                aliceTurn = false;
                sums[curr[1]] = _aliceValues[curr[1]];
            } else {
                aliceTurn = true;
                sums[curr[1]] = -_bobValues[curr[1]];
            }
        }
        int sum = 0;
        for (int s : sums) {
            sum += s;
        }
        return Integer.compare(sum, 0);
    }

}
