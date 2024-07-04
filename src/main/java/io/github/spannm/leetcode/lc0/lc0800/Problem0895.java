package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Problem0895 extends LeetcodeProblem {

    static class FreqStack {
        private int                         counter;
        private final PriorityQueue<int[]>  maxHeap;
        private final Map<Integer, Integer> map;

        FreqStack() {
            maxHeap = new PriorityQueue<>((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[2] - a[2]);
            map = new HashMap<>();
        }

        void push(int _x) {
            map.put(_x, map.getOrDefault(_x, 0) + 1);
            maxHeap.offer(new int[] {_x, map.get(_x), counter++});
        }

        int pop() {
            int[] top = maxHeap.poll();
            map.put(top[0], map.get(top[0]) - 1);
            return top[0];
        }
    }

}
