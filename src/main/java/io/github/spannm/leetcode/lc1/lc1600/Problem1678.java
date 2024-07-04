package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1678 extends LeetcodeProblem {

    String interpret(String _command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _command.length(); i++) {
            if (_command.charAt(i) == 'G') {
                sb.append("G");
            } else if (_command.charAt(i) == '(' && _command.charAt(i + 1) == ')') {
                sb.append("o");
                i++;
            } else if (_command.charAt(i) == '(' && _command.charAt(i + 1) == 'a') {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }

}
