package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/longest-valid-parentheses/">32. Longest Valid Parentheses</a>.
 */
class Problem0032 extends LeetcodeProblem {

    int longestValidParentheses(String _s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

}
