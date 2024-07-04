package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/simplify-path/">71. Simplify Path</a>.
 */
class Problem0071 extends LeetcodeProblem {

    private static final String SLASH  = "/";
    private static final String DOT    = ".";
    private static final String DOTDOT = "..";

    String simplifyPath(String _path) {
        Deque<String> q = new ArrayDeque<>();
        // iterate over string and add path to q
        for (String s : _path.split(SLASH)) {
            if (s.isEmpty() || s.equals(DOT)) {
                continue;
            }

            if (s.equals(DOTDOT)) {
                if (!q.isEmpty()) {
                    q.removeLast();
                }
            } else {
                q.addLast(s);
            }
        }
        return q.isEmpty() ? SLASH : SLASH + String.join(SLASH, q.toArray(String[]::new));
    }

}
