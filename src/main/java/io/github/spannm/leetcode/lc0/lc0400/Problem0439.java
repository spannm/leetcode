package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

class Problem0439 extends LeetcodeProblem {

    String parseTernary(String _expression) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> tmpStack = new ArrayDeque<>();
        for (char c : _expression.toCharArray()) {
            stack.addFirst(c);
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != '?') {
                tmpStack.addFirst(stack.pollFirst());
            } else {
                char char1 = tmpStack.removeFirst();
                tmpStack.removeFirst();
                char char2 = tmpStack.removeFirst();
                stack.removeFirst();
                char judge = stack.removeFirst();
                tmpStack.addFirst(judge == 'T' ? char1 : char2);
                while (!tmpStack.isEmpty()) {
                    stack.addFirst(tmpStack.pollFirst());
                }
            }
            if (stack.size() == 1) {
                break;
            }
        }
        return Character.toString(stack.removeFirst());
    }

}
