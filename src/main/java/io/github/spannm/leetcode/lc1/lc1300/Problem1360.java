package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1360 extends LeetcodeProblem {

    int daysBetweenDates(String _date1, String _date2) {
        String[] strings1 = _date1.split("-");
        String[] strings2 = _date2.split("-");
        return Math.abs(julianDay(Integer.parseInt(strings1[0]), Integer.parseInt(strings1[1]), Integer.parseInt(strings1[2]))
            - julianDay(Integer.parseInt(strings2[0]), Integer.parseInt(strings2[1]), Integer.parseInt(strings2[2])));
    }

    int julianDay(int _year, int _month, int _day) {
        int a = (14 - _month) / 12;
        int y = _year + 4800 - a;
        int m = _month + 12 * a - 3;
        return _day + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32045;
    }

}
