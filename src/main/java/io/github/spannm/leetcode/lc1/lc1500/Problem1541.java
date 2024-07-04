package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem1541 extends LeetcodeProblem {

    int minInsertions(String _s) {
        Stack<Character> stack = new Stack<>();
        int insertionsNeeded = 0;
        for (int i = 0; i < _s.length(); i++) {
            char c = _s.charAt(i);
            if (c == '(') {
                if (stack.isEmpty()) {
                    stack.add(c);
                } else {
                    if (stack.peek() == ')') {

                        insertionsNeeded++;
                        stack.pop();
                        stack.pop();
                        stack.add(c);
                    } else {
                        stack.add(c);
                    }
                }
            } else if (c == ')') {
                if (stack.isEmpty()) {

                    insertionsNeeded++;
                    stack.add('(');
                    stack.add(c);
                } else {
                    if (stack.peek() == ')') {

                        stack.pop();
                        stack.pop();
                    } else {
                        stack.add(c);
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                char pop = stack.pop();
                if (pop == '(') {
                    insertionsNeeded += 2;
                } else {
                    insertionsNeeded++;
                    stack.pop();
                }
            }
        }
        return insertionsNeeded;
    }

}
