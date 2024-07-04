package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/wildcard-matching/">44. Wildcard Matching</a>.
 */
class Problem0044 extends LeetcodeProblem {

    boolean isMatch(String _str, String _pattern) {
        final int slen = _str.length();
        final int plen = _pattern.length();

        boolean[][] match = new boolean[slen + 1][plen + 1];
        match[slen][plen] = true;
        for (int i = plen - 1; i >= 0; i--) {
            if (_pattern.charAt(i) != '*') {
                break;
            } else {
                match[slen][i] = true;
            }
        }

        for (int i = slen - 1; i >= 0; i--) {
            for (int j = plen - 1; j >= 0; j--) {
                if (_str.charAt(i) == _pattern.charAt(j) || _pattern.charAt(j) == '?') {
                    match[i][j] = match[i + 1][j + 1];
                } else if (_pattern.charAt(j) == '*') {
                    match[i][j] = match[i + 1][j] || match[i][j + 1];
                } else {
                    match[i][j] = false;
                }
            }
        }
        return match[0][0];
    }

}
