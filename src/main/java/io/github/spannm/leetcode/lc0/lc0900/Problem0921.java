package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0921 extends LeetcodeProblem {

    int minAddToMakeValid(String _s) {
        Stack<Character> stack = new Stack<>();
        for (char c : _s.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

}
