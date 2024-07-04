package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0716 extends LeetcodeProblem {

    static class MaxStack {

        private int                  max;
        private final Stack<Integer> stack;

        MaxStack() {
            max = Integer.MIN_VALUE;
            stack = new Stack<>();
        }

        void push(int _x) {
            if (_x > max) {
                max = _x;
            }
            stack.push(_x);
        }

        int pop() {
            if (stack.peek() == max) {
                int result = stack.pop();
                max = findMax();
                return result;
            } else {
                return stack.pop();
            }
        }

        private int findMax() {
            if (!stack.isEmpty()) {
                int mx = stack.peek();
                for (Integer element : stack) {
                    mx = Math.max(mx, element);
                }
                return mx;
            } else {
                max = Integer.MIN_VALUE;
                return max;
            }
        }

        int top() {
            return stack.peek();
        }

        int peekMax() {
            return max;
        }

        int popMax() {
            Stack<Integer> tmp = new Stack<>();
            int result = 0;
            while (!stack.isEmpty()) {
                if (stack.peek() != max) {
                    tmp.push(stack.pop());
                } else {
                    result = stack.pop();
                    break;
                }
            }
            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
            max = findMax();
            return result;
        }
    }

}
