package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0856 extends LeetcodeProblem {

    int scoreOfParentheses(String _s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) == '(') {
                stack.push(-1);
            } else {
                int curr = 0;
                while (stack.peek() != -1) {
                    curr += stack.pop();
                }
                stack.pop();
                stack.push(curr == 0 ? 1 : curr * 2);
            }
        }
        int score = 0;
        while (!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }

}
