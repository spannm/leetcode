package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2734. Lexicographically Smallest String After Substring Operation.
 */
class Problem2734 extends LeetcodeProblem {

    String smallestString(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == 'a') {
            i++;
        }
        if (i == n) {
            return s.substring(0, n - 1) + "z";
        }
        int j = i;
        char[] cs = s.toCharArray();
        while (j < n && cs[j] != 'a') {
            cs[j] = (char) (cs[j] - 1);
            j++;
        }
        return String.valueOf(cs);
    }

}
