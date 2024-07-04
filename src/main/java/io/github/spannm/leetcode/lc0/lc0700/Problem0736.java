package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 736. Parse Lisp Expression.
 */
class Problem0736 extends LeetcodeProblem {

    private int                               i;
    private String                            expr;
    private final Map<String, Deque<Integer>> scope = new HashMap<>();

    int evaluate(String _expr) {
        expr = _expr;
        return eval();
    }

    private int eval() {
        char c = expr.charAt(i);
        if (c != '(') {
            return Character.isLowerCase(c) ? scope.get(parseVar()).peekLast() : parseInt();
        }
        i++;
        c = expr.charAt(i);
        int ans = 0;
        if (c == 'l') {
            i += 4;
            List<String> vars = new ArrayList<>();
            while (true) {
                String var = parseVar();
                if (expr.charAt(i) == ')') {
                    ans = scope.get(var).peekLast();
                    break;
                }
                vars.add(var);
                i++;
                scope.computeIfAbsent(var, k -> new ArrayDeque<>()).offer(eval());
                i++;
                if (!Character.isLowerCase(expr.charAt(i))) {
                    ans = eval();
                    break;
                }
            }
            for (String v : vars) {
                scope.get(v).pollLast();
            }
        } else {
            boolean add = c == 'a';
            i += add ? 4 : 5;
            int a = eval();
            i++;
            int b = eval();
            ans = add ? a + b : a * b;
        }
        i++;
        return ans;
    }

    private String parseVar() {
        int j = i;
        while (i < expr.length() && expr.charAt(i) != ' ' && expr.charAt(i) != ')') {
            i++;
        }
        return expr.substring(j, i);
    }

    private int parseInt() {
        int sign = 1;
        if (expr.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int v = 0;
        while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
            v = v * 10 + expr.charAt(i) - '0';
            i++;
        }
        return sign * v;
    }

}
