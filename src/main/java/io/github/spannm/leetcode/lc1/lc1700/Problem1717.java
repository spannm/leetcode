package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem1717 extends LeetcodeProblem {

    int maximumGain(String _s, int _x, int _y) {
        Stack<Character> stack1 = new Stack<>();
        int big = Math.max(_x, _y);
        int small = big == _x ? _y : _x;
        char first = _x == big ? 'a' : 'b';
        char second = first == 'a' ? 'b' : 'a';
        int maximumGain = 0;
        for (char c : _s.toCharArray()) {
            if (c == second && !stack1.isEmpty() && stack1.peek() == first) {
                stack1.pop();
                maximumGain += big;
            } else {
                stack1.push(c);
            }
        }
        Stack<Character> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            char c = stack1.pop();
            if (c == second && !stack2.isEmpty() && stack2.peek() == first) {
                stack2.pop();
                maximumGain += small;
            } else {
                stack2.push(c);
            }
        }
        return maximumGain;
    }

}
