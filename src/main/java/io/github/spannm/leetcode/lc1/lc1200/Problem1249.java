package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem1249 extends LeetcodeProblem {

    String minRemoveToMakeValid(String _s) {
        Stack<Character> stack = new Stack<>();
        int leftParens = 0;
        int rightParens = 0;
        for (char c : _s.toCharArray()) {
            if ('(' == c) {
                stack.push(c);
                leftParens++;
            } else if (')' == c) {
                if (leftParens > rightParens) {
                    stack.push(c);
                    rightParens++;
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int diff = leftParens - rightParens;
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                if (diff-- > 0) {
                    stack.pop();
                } else {
                    sb.append(stack.pop());
                }
            } else {
                sb.append(stack.pop());
            }
        }
        return sb.reverse().toString();
    }

}
