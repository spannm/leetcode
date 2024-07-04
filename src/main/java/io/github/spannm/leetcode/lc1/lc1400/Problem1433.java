package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1433. Check If a String Can Break Another String.
 */
class Problem1433 extends LeetcodeProblem {

    boolean checkIfCanBreak(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        return check(cs1, cs2) || check(cs2, cs1);
    }

    private boolean check(char[] cs1, char[] cs2) {
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] < cs2[i]) {
                return false;
            }
        }
        return true;
    }

}
