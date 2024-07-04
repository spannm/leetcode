package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Deque;
import java.util.LinkedList;

class Problem2696 extends LeetcodeProblem {

    int minLength(String _s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < _s.length(); i++) {
            if (stack.isEmpty()) {
                stack.addLast(_s.charAt(i));
            } else if (_s.charAt(i) == 'B' && stack.peekLast() == 'A') {
                stack.pollLast();
            } else if (_s.charAt(i) == 'D' && stack.peekLast() == 'C') {
                stack.pollLast();
            } else {
                stack.addLast(_s.charAt(i));
            }
        }
        return stack.size();
    }

}
