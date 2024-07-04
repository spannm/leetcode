package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1118 extends LeetcodeProblem {

    int numberOfDays(int _y, int _m) {
        int[] map = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(_y) && _m == 2) {
            return 29;
        } else {
            return map[_m];
        }
    }

    private static boolean isLeapYear(int _year) {
        return _year % 4 == 0 && (_year % 100 != 0 || _year % 400 == 0);
    }

}
