package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/implement-stack-using-queues/">225. Implement Stack using Queues</a>.
 */
class Problem0225 extends LeetcodeProblem {

    static class MyStack {
        private final Queue<Integer> queue;

        MyStack() {
            queue = new LinkedList<>();
        }

        void push(int _x) {
            queue.add(_x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.remove());
            }
        }

        int pop() {
            return queue.remove();
        }

        int top() {
            return queue.peek();
        }

        boolean empty() {
            return queue.isEmpty();
        }
    }

}
