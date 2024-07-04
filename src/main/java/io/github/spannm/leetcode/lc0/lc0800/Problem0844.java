package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/backspace-string-compare/">844. Backspace String Compare</a>.
 */
class Problem0844 extends LeetcodeProblem {

    boolean backspaceCompare(String _s, String _t) {
        return process(_s).equals(process(_t));
    }

    static String process(String _s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) == '#') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(_s.charAt(i));
            }
        }
        return sb.reverse().toString();
    }

}
