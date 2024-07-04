package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/">239. Sliding Window Maximum</a>.
 */
class Problem0239 extends LeetcodeProblem {

    int[] maxSlidingWindow(int[] _nums, int _k) {
        final int len = _nums.length;
        final int[] out = new int[len - _k + 1];
        int outidx = 0;
        final java.util.Deque<Integer> deq = new java.util.ArrayDeque<>(3); // stores *indices*

        for (int i = 0; i < len; i++) {
            while (!deq.isEmpty() && _nums[deq.getLast()] <= _nums[i]) {
                deq.removeLast();
            }
            deq.addLast(i);
            if (deq.getFirst() == i - _k) {
                deq.removeFirst();
            }
            if (i >= _k - 1) {
                out[outidx++] = _nums[deq.peek()];
            }
        }
        return out;
    }

}
