package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem0632 extends LeetcodeProblem {

    int[] smallestRange(List<List<Integer>> _nums) {
        int sz = _nums.size();
        Queue<int[]> minHeap = new PriorityQueue<>(sz, Comparator.comparingInt(a -> a[0]));

        int max = _nums.get(0).get(0);
        for (int i = 0; i < sz; i++) {
            minHeap.offer(new int[] {_nums.get(i).get(0), i, 0});
            max = Math.max(max, _nums.get(i).get(0));
        }
        int minRange = Integer.MAX_VALUE;
        int start = -1;
        while (minHeap.size() == sz) {
            int[] curr = minHeap.poll();
            if (max - curr[0] < minRange) {
                minRange = max - curr[0];
                start = curr[0];
            }
            if (curr[2] + 1 < _nums.get(curr[1]).size()) {
                curr[0] = _nums.get(curr[1]).get(curr[2] + 1);
                curr[2]++;
                minHeap.offer(curr);
                max = Math.max(max, curr[0]);
            }
        }
        return new int[] {start, start + minRange};
    }

}
