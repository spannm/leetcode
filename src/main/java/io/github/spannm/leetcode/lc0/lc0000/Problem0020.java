package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">20. Valid Parentheses</a>.
 */
class Problem0020 extends LeetcodeProblem {

    boolean isValid(String _s) {
        if (_s == null) {
            return true;
        } else if (_s.length() % 2 != 0) {
            return false;
        }

        final java.util.Stack<Byte> stack = new java.util.Stack<>();
        for (byte b : _s.getBytes()) {
            if (b == '(' || b == '[' || b == '{') {
                stack.push(b);
            } else if (stack.isEmpty()
                || b == ')' && stack.pop() != '('
                || b == ']' && stack.pop() != '['
                || b == '}' && stack.pop() != '{') {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
