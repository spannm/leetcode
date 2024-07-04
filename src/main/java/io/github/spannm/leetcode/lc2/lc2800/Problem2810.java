package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2810. Faulty Keyboard.
 */
class Problem2810 extends LeetcodeProblem {

    String finalString(String s) {
        StringBuilder t = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                t.reverse();
            } else {
                t.append(c);
            }
        }
        return t.toString();
    }

}
