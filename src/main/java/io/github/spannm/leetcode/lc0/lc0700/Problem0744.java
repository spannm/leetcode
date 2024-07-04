package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/">744. Find Smallest Letter Greater
 * Than Target</a>.
 */
class Problem0744 extends LeetcodeProblem {

    static char nextGreatestLetter(final char[] _letters, final char _target) {
        char first = _letters[0];
        Arrays.sort(_letters);
        for (char l : _letters) {
            if (l > _target) {
                return l;
            }
        }
        return first;
    }

}
