package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0232 extends LeetcodeProblem {

    static class MyQueue {
        private final Stack<Integer> input  = new Stack<>();
        private final Stack<Integer> output = new Stack<>();

        public void push(int _x) {
            input.push(_x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

}
