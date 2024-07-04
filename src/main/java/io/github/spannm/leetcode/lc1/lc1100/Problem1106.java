package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1106. Parsing A Boolean Expression.
 */
class Problem1106 extends LeetcodeProblem {

    boolean parseBoolExpr(String _expression) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : _expression.toCharArray()) {
            if (c != '(' && c != ')' && c != ',') {
                dq.push(c);
            } else if (c == ')') {
                int t = 0;
                int f = 0;
                while (dq.peek() == 't' || dq.peek() == 'f') {
                    t += dq.peek() == 't' ? 1 : 0;
                    f += dq.peek() == 'f' ? 1 : 0;
                    dq.pop();
                }
                char op = dq.pop();
                c = 'f';
                if (op == '!' && f > 0 || op == '&' && f == 0 || op == '|' && t > 0) {
                    c = 't';
                }
                dq.push(c);
            }
        }
        return dq.peek() == 't';
    }

}
