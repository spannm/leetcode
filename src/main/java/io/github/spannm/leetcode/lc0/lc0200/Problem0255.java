package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0255 extends LeetcodeProblem {

    boolean verifyPreorder(int[] _preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int p : _preorder) {
            if (p < low) {
                return false;
            }
            while (!stack.empty() && p > stack.peek()) {
                low = stack.pop();
            }
            stack.push(p);
        }
        return true;
    }

}
