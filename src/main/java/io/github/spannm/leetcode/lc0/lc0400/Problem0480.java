package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 480. Sliding Window Median.
 */
class Problem0480 extends LeetcodeProblem {

    double[] medianSlidingWindow(int[] _nums, int _k) {
        MedianFinder finder = new MedianFinder(_k);
        for (int i = 0; i < _k; i++) {
            finder.addNum(_nums[i]);
        }
        int n = _nums.length;
        double[] ans = new double[n - _k + 1];
        ans[0] = finder.findMedian();
        for (int i = _k; i < n; i++) {
            finder.addNum(_nums[i]);
            finder.removeNum(_nums[i - _k]);
            ans[i - _k + 1] = finder.findMedian();
        }
        return ans;
    }

    static class MedianFinder {
        private final Queue<Integer>        small   = new PriorityQueue<>(Comparator.reverseOrder());
        private final Queue<Integer>        large   = new PriorityQueue<>();
        private final Map<Integer, Integer> delayed = new HashMap<>();
        private int                         smallSize;
        private int                         largeSize;
        private final int                   k;

        MedianFinder(int _k) {
            k = _k;
        }

        public void addNum(int _num) {
            if (small.isEmpty() || _num <= small.peek()) {
                small.offer(_num);
                smallSize++;
            } else {
                large.offer(_num);
                largeSize++;
            }
            rebalance();
        }

        public double findMedian() {
            return (k & 1) == 1 ? small.peek() : (small.peek() + large.peek()) / 2D;
        }

        public void removeNum(int _num) {
            delayed.merge(_num, 1, Integer::sum);
            if (_num <= small.peek()) {
                smallSize--;
                if (_num == small.peek()) {
                    prune(small);
                }
            } else {
                largeSize--;
                if (_num == large.peek()) {
                    prune(large);
                }
            }
            rebalance();
        }

        private void prune(Queue<Integer> _pq) {
            while (!_pq.isEmpty() && delayed.containsKey(_pq.peek())) {
                if (delayed.merge(_pq.peek(), -1, Integer::sum) == 0) {
                    delayed.remove(_pq.peek());
                }
                _pq.poll();
            }
        }

        private void rebalance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.poll());
                smallSize--;
                largeSize++;
                prune(small);
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                largeSize--;
                smallSize++;
                prune(large);
            }
        }

    }

}
