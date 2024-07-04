package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/reverse-string/">344. Reverse String</a>.
 */
class Problem0344 extends LeetcodeProblem {

    char[] reverseString(char[] _chars) {
        int len = _chars.length;
        if (len > 1) {
            int ri = len - 1;
            for (int li = 0; li < ri; li++, ri--) {
                char leftChar = _chars[li];
                _chars[li] = _chars[ri];
                _chars[ri] = leftChar;
            }
        }
        return _chars;
    }

}
