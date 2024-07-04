package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem0719 extends LeetcodeProblem {

    int smallestDistancePair(int[] _nums, int _k) {
        if (_nums == null || _nums.length == 0) {
            return 0;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < _nums.length - 1; i++) {
            for (int j = i + 1; j < _nums.length; j++) {
                minHeap.offer(Math.abs(_nums[j] - _nums[i]));
            }
        }

        int result = 0;
        while (_k-- > 0) {
            result = minHeap.poll();
        }
        return result;
    }

}
