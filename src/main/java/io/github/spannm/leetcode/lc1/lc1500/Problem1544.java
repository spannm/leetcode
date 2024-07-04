package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;
import java.util.stream.Collectors;

class Problem1544 extends LeetcodeProblem {

    String makeGood(String _s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < _s.length(); i++) {
            char c = _s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                char clc = Character.toLowerCase(c);
                Character pc = stack.peek();
                if (Character.toLowerCase(pc) == clc) {
                    if (Character.isLowerCase(pc) && Character.isUpperCase(c)) {
                        stack.pop();
                    } else if (Character.isUpperCase(pc) && Character.isLowerCase(c)) {
                        stack.pop();
                    } else {
                        stack.add(c);
                    }
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

}
