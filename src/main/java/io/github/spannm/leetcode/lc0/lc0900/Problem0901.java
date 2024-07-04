package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0901 extends LeetcodeProblem {

    static class StockSpanner {
        private final Stack<int[]> stack;

        StockSpanner() {
            stack = new Stack<>();
        }

        int next(int _price) {
            int result = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= _price) {
                result += stack.pop()[1];
            }
            stack.push(new int[] {_price, result});
            return result;
        }
    }

}
