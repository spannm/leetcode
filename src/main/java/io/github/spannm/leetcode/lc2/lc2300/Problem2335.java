package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem2335 extends LeetcodeProblem {

    int fillCups(int[] _amount) {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(_amount).filter(n -> n > 0).forEach(heap::offer);
        int seconds = 0;
        while (!heap.isEmpty()) {
            if (heap.size() == 1) {
                seconds += heap.poll();
                return seconds;
            }
            int one = heap.poll();
            one--;
            if (!heap.isEmpty()) {
                int two = heap.poll();
                two--;
                if (two > 0) {
                    heap.offer(two);
                }
            }
            if (one > 0) {
                heap.offer(one);
            }
            seconds++;
        }
        return seconds;
    }

}
