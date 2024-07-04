package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem1614 extends LeetcodeProblem {

    int maxDepth(String _s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for (char c : _s.toCharArray()) {
            if ('(' == c) {
                stack.push(c);
            } else if (')' == c) {
                int sz = stack.size();
                if (sz > maxDepth) {
                    maxDepth = sz;
                }
                stack.pop();
            }
        }
        return maxDepth;
    }

}
