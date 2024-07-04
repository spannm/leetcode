package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

class Problem0331 extends LeetcodeProblem {

    boolean isValidSerialization(String _preorder) {
        if (_preorder.isEmpty()) {
            return false;
        }
        String[] pre = _preorder.split(",");
        Deque<String> stack = new ArrayDeque<>();
        for (String element : pre) {
            while ("#".equals(element) && !stack.isEmpty() && "#".equals(stack.peekLast())) {
                stack.pollLast();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pollLast();
            }
            stack.addLast(element);
        }
        return stack.size() == 1 && stack.peekLast().equals("#");
    }

}
