package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One.
 */
class Problem1404 extends LeetcodeProblem {

    int numSteps(String _s) {
        char[] arr = _s.toCharArray();
        boolean carry = false;
        int result = 0;

        for (int i = arr.length - 1; i > 0; i--) {
            char c = arr[i];
            if (carry) {
                if (c == '0') {
                    c = '1';
                    carry = false;
                } else {
                    c = '0';
                }
            }
            if (c == '1') {
                result++;
                carry = true;
            }
            result++;
        }
        if (carry) {
            result++;
        }
        return result;
    }

}
