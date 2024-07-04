package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0415 extends LeetcodeProblem {

    String addStrings(String _num1, String _num2) {
        StringBuilder sb = new StringBuilder();
        int i = _num1.length() - 1;
        int j = _num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += Character.getNumericValue(_num1.charAt(i));
            }
            if (j >= 0) {
                sum += Character.getNumericValue(_num2.charAt(j));
            }
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
