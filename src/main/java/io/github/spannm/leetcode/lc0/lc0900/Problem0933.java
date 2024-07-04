package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Deque;
import java.util.LinkedList;

class Problem0933 extends LeetcodeProblem {

    static class RecentCounter {

        private final Deque<Integer> deque;

        RecentCounter() {
            deque = new LinkedList<>();
        }

        int ping(int _t) {
            while (!deque.isEmpty() && _t - deque.getFirst() > 3000) {
                deque.removeFirst();
            }
            deque.addLast(_t);
            return deque.size();
        }
    }

}
