package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/">7. Reverse Integer</a>.
 */
class Problem0007 extends LeetcodeProblem {

    int reverse(int _x) {
        long l = _x;
        boolean isNegative = l < 0;
        if (isNegative) {
            l *= -1;
        }
        String revStr = new StringBuilder(Long.toString(l)).reverse().toString();
        long rev = Long.parseLong(revStr);
        if (rev > Integer.MAX_VALUE) {
            return 0;
        } else if (isNegative) {
            rev *= -1;
        }
        return (int) rev;
    }

}
