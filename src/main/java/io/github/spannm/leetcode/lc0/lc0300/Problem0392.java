package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/is-subsequence/">392. Is Subsequence</a>.
 */
class Problem0392 extends LeetcodeProblem {

    boolean isSubsequence(String _sub, String _str) {
        final int subLen = _sub.length();
        if (subLen == 0) {
            return true;
        }
        final int strLen = _str.length();
        if (subLen > strLen) {
            return false;
        }

        boolean found;
        int istr = 0;
        for (int isub = 0; isub < subLen; isub++) {
            found = false;
            for (; istr < strLen; istr++) {
                if (_sub.charAt(isub) == _str.charAt(istr)) {
                    found = true;
                    istr++;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }

}
