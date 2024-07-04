package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

class Problem1354 extends LeetcodeProblem {

    boolean isPossible(int[] _target) {
        long sum = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int element : _target) {
            maxHeap.offer(element);
            sum += element;
        }
        while (maxHeap.peek() != 1) {
            int max = maxHeap.poll();
            sum -= max;
            if (max <= sum || sum < 1) {
                return false;
            }
            max %= sum;
            sum += max;
            maxHeap.offer(max);
        }
        return true;
    }

}
