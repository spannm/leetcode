package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem1209 extends LeetcodeProblem {

    String removeDuplicates(String _s, int _k) {
        Stack<Character> stack = new Stack<>();
        char c = _s.charAt(0);
        stack.push(c);
        int count = 1;
        for (int i = 1; i < _s.length(); i++) {
            if (_s.charAt(i) == c) {
                count++;
                stack.push(_s.charAt(i));
                if (count == _k) {
                    while (!stack.isEmpty() && stack.peek() == c) {
                        stack.pop();
                    }
                    count = 0;
                    if (!stack.isEmpty()) {
                        c = stack.peek();
                        while (!stack.isEmpty() && c == stack.peek()) {
                            count++;
                            stack.pop();
                        }
                        int tmp = count;
                        while (tmp-- > 0) {
                            stack.push(c);
                        }
                    }
                }
            } else {
                c = _s.charAt(i);
                stack.push(_s.charAt(i));
                count = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
