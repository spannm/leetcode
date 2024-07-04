package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1903 extends LeetcodeProblem {

    String largestOddNumber(String _num) {
        for (int i = _num.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(_num.charAt(i));
            if (n % 2 == 1) {
                return _num.substring(0, i + 1);
            }
        }
        return "";
    }

}
