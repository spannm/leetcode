package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-the-difference/">389. Find the Difference</a>.
 */
class Problem0389 extends LeetcodeProblem {

    char findTheDifference(String _s, String _t) {
        char[] s = _s.toCharArray();
        Arrays.sort(s);
        char[] t = _t.toCharArray();
        Arrays.sort(t);

        for (int i = 0; i < s.length; i++) {
            if (s[i] != t[i]) {
                return t[i];
            }
        }

        char answer = t[t.length - 1];

        s = null;
        t = null;

        return answer;
    }

}
