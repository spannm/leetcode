package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Problem1190 extends LeetcodeProblem {

    String reverseParentheses(String _s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (char c : _s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    queue.offer(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
