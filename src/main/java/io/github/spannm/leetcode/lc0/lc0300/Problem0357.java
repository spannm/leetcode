package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0357 extends LeetcodeProblem {

    int countNumbersWithUniqueDigits(int _n) {
        if (_n == 0) {
            return 1;
        }
        int res = 10;
        int uniqueDigits = 9;
        int availNumber = 9;
        while (_n-- > 1 && availNumber > 0) {
            uniqueDigits = uniqueDigits * availNumber;
            res += uniqueDigits;
            availNumber--;
        }
        return res;
    }

}
