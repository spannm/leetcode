package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Objects;

class Problem0520 extends LeetcodeProblem {

    boolean detectCapitalUse(String _word) {
        Objects.requireNonNull(_word, "Word required");
        final int len = _word.length();

        if (len < 1 || len > 100) {
            throw new IllegalArgumentException("Invalid word length");
        } else if (len == 1) {
            return true;
        } else if (Character.isUpperCase(_word.charAt(0))) {
            // remaining chars must be all lower- or all upper-case
            boolean prevLower = Character.isLowerCase(_word.charAt(1));
            for (int i = 2; i < len; i++) {
                if (prevLower != Character.isLowerCase(_word.charAt(i))) {
                    return false;
                }
            }
        } else {
            // remaining chars must be all lower-case
            for (int i = 1; i < len; i++) {
                if (!Character.isLowerCase(_word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

}
