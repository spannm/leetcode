package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem0295 extends LeetcodeProblem {

    static class MedianFinder {
        private final Queue<Long> large = new PriorityQueue<>();
        private final Queue<Long> small = new PriorityQueue<>(Comparator.reverseOrder());

        public void addNum(int _num) {
            large.offer((long) _num);
            small.offer(large.poll());
            if (large.size() < small.size()) {
                large.offer(small.poll());
            }
        }

        public double findMedian() {
            if (large.size() > small.size()) {
                return large.peek();
            }
            return (large.peek() + small.peek()) / 2.0;
        }
    }

}
