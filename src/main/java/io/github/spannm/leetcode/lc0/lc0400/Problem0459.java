package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/repeated-substring-pattern/">459. Repeated Substring Pattern</a>.
 */
class Problem0459 extends LeetcodeProblem {

    boolean repeatedSubstringPattern(String _s) {
        final int len = _s.length();

        for (int sublen = len / 2; sublen > 0; sublen--) {
            if (len % sublen == 0) {
                if (_s.charAt(0) == _s.charAt(sublen)) { // compare leftmost chars of candidates
                    if (_s.charAt(sublen - 1) == _s.charAt(len - 1)) { // compare rightmost chars of candidates
                        String str = _s.substring(0, sublen); // first substring
                        int repeatCount = len / sublen;
                        if (str.repeat(repeatCount).equals(_s)) { // compare repeated substring to input
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
