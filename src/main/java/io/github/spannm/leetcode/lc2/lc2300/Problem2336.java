package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/">2336. Smallest Number in Infinite Set</a>.
 */
class Problem2336 extends LeetcodeProblem {

    static class SmallestInfiniteSet {
        private int                  min  = 1;
        private final Queue<Integer> heap = new PriorityQueue<>();

        public int popSmallest() {
            if (!heap.isEmpty()) {
                return heap.poll();
            }
            min++;
            return min - 1;
        }

        public void addBack(int _num) {
            if (min > _num && !heap.contains(_num)) {
                heap.offer(_num);
            }
        }
    }

}
