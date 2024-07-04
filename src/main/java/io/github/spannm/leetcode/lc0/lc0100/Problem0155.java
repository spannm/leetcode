package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0155 extends LeetcodeProblem {

    static class MinStack {
        private final Stack<Integer> stack;
        private int                  min;

        MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int _x) {
            if (_x <= min) {
                stack.push(min);
                min = _x;
            }
            stack.push(_x);
        }

        public void pop() {
            if (min == stack.pop()) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

}
