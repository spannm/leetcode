package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1946. Largest Number After Mutating Substring.
 */
class Problem1946 extends LeetcodeProblem {

    String maximumNumber(String num, int[] change) {
        char[] s = num.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (change[s[i] - '0'] > s[i] - '0') {
                for (; i < s.length && s[i] - '0' <= change[s[i] - '0']; i++) {
                    s[i] = (char) (change[s[i] - '0'] + '0');
                }
                break;
            }
        }
        return String.valueOf(s);
    }

}
