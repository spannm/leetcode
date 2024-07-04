package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/calculate-money-in-leetcode-bank/">1716. Calculate Money in Leetcode Bank</a>.
 */
class Problem1716 extends LeetcodeProblem {

    int totalMoney(int _n) {
        int mondayMoney = 1;
        int total = 0;
        while (_n > 0) {
            int weekDays = 0;
            int base = mondayMoney;
            while (weekDays < 7 && _n > 0) {
                total += base;
                base++;
                weekDays++;
                _n--;
            }
            mondayMoney++;
        }
        return total;
    }

}
