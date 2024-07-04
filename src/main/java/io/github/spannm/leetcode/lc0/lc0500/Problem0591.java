package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

class Problem0591 extends LeetcodeProblem {

    boolean isValid(String _code) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < _code.length();) {
            if (i > 0 && stack.isEmpty()) {
                return false;
            } else if (_code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = _code.indexOf("]]>", j);
                if (i < 0) {
                    return false;
                }
                i += 3;
            } else if (_code.startsWith("</", i)) {
                int j = i + 2;
                i = _code.indexOf('>', j);
                if (i < 0 || i == j || i - j > 9) {
                    return false;
                }
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(_code.charAt(k))) {
                        return false;
                    }
                }
                String s = _code.substring(j, i++);
                if (stack.isEmpty() || !stack.pop().equals(s)) {
                    return false;
                }
            } else if (_code.startsWith("<", i)) {
                int j = i + 1;
                i = _code.indexOf('>', j);
                if (i < 0 || i == j || i - j > 9) {
                    return false;
                }
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(_code.charAt(k))) {
                        return false;
                    }
                }
                String s = _code.substring(j, i++);
                stack.push(s);
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }

}
