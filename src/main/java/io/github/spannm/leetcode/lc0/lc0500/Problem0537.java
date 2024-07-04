package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 537. Complex Number Multiplication.
 */
class Problem0537 extends LeetcodeProblem {

    String complexNumberMultiply(String _num1, String _num2) {
        String[] num1 = _num1.split("\\+|i");
        String[] num2 = _num2.split("\\+|i");
        int n11 = Integer.parseInt(num1[0]);
        int n12 = Integer.parseInt(num1[1]);
        int n21 = Integer.parseInt(num2[0]);
        int n22 = Integer.parseInt(num2[1]);
        return String.format("%d+%di",
            n11 * n21 - n12 * n22,
            n11 * n22 + n21 * n12);
    }

}
