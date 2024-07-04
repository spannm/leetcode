package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0394 extends LeetcodeProblem {

    String decodeString(String _s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> str = new Stack<>();

        int idx = 0;
        str.push("");

        while (idx < _s.length()) {
            char c = _s.charAt(idx);
            if (c >= '0' && c <= '9') {
                int start = idx;
                while (_s.charAt(idx + 1) >= '0' && _s.charAt(idx + 1) <= '9') {
                    idx++;
                }
                count.push(Integer.parseInt(_s.substring(start, idx + 1)));
            } else if ('[' == c) {
                str.push("");
            } else if (']' == c) {
                String popped = str.pop();
                int n = count.pop();
                String repeated = String.valueOf(popped).repeat(Math.max(0, n));
                str.push(str.pop() + repeated);
            } else {
                str.push(str.pop() + c);
            }

            idx++;
        }

        String result = str.pop();
        count = null;
        str = null;
        return result;
    }

}
