package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

class Problem1438 extends LeetcodeProblem {

    int longestSubarray(int[] _nums, int _limit) {
        int len = _nums.length;
        int result = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int left = 0, right = 0; left < len && right < len; right++) {
            if (result == 0) {
                result = 1;
            }
            maxHeap.offer(_nums[right]);
            minHeap.offer(_nums[right]);
            if (!maxHeap.isEmpty() && !minHeap.isEmpty()
                && maxHeap.peek() - minHeap.peek() <= _limit) {
                result = Math.max(result, right - left + 1);
            } else {
                maxHeap.remove(_nums[left]);
                minHeap.remove(_nums[left]);
                left++;
            }
        }
        return result;
    }

}
