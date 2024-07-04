package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/isomorphic-strings/">205. Isomorphic Strings</a>.
 */
class Problem0205 extends LeetcodeProblem {

    boolean isIsomorphic(String _a, String _b) {
        final int len = _a.length();
        if (len != _b.length()) {
            return false;
        }
        final Map<Character, Character> aToB = new HashMap<>();
        final Map<Character, Character> bToA = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char aNow = _a.charAt(i);
            char bNow = _b.charAt(i);
            Character bPrev = aToB.put(aNow, bNow);
            if (bPrev != null && bPrev != bNow) {
                return false;
            }
            Character aPrev = bToA.put(bNow, aNow);
            if (aPrev != null && aPrev != aNow) {
                return false;
            }
        }
        return true;
    }

}
