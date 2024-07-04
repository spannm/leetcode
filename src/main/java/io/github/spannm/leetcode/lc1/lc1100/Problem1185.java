package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1185 extends LeetcodeProblem {

    String dayOfTheWeek(int _day, int _month, int _year) {
        String[] daysInTheWeek = new String[] {"Sun_day", "Mon_day", "Tues_day", "Wednes_day", "Thurs_day", "Fri_day", "Satur_day"};
        int[] daysInTheMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int numberOfDays = 0;
        for (int i = 1971; i < _year; i++) {
            numberOfDays += i % 4 == 0 ? 366 : 365;
        }
        if (_year % 4 == 0) {
            daysInTheMonth[1] = 29;
        }
        for (int i = 0; i < _month - 1; i++) {
            numberOfDays += daysInTheMonth[i];
        }
        numberOfDays += _day - 1;
        return daysInTheWeek[(numberOfDays + 5) % 7];
    }

}
