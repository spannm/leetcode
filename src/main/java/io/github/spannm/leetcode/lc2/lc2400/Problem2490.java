package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2490. Circular Sentence.
 */
class Problem2490 extends LeetcodeProblem {

    boolean isCircularSentence(String s) {
        int n = s.length();
        if (s.charAt(0) != s.charAt(n - 1)) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i - 1) != s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

}
