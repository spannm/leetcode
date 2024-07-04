package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

class Problem0227 extends LeetcodeProblem {

    int calculate(String _s) {
        if (_s == null || _s.isEmpty()) {
            return 0;
        }
        int len = _s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(_s.charAt(i))) {
                num = num * 10 + _s.charAt(i) - '0';
            }
            if (!Character.isDigit(_s.charAt(i)) && ' ' != _s.charAt(i) || i == len - 1) {
                if (sign == '+') {
                    stack.addLast(num);
                } else if (sign == '-') {
                    stack.addLast(-num);
                } else if (sign == '/') {
                    stack.addLast(stack.pollLast() / num);
                } else if (sign == '*') {
                    stack.addLast(stack.pollLast() * num);
                }
                sign = _s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.poll();
        }
        return result;
    }

}
