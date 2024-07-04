package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

class Problem1003 extends LeetcodeProblem {

    boolean isValid(String _s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : _s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b' || stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
