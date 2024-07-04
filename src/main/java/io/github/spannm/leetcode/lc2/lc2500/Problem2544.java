package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2544 extends LeetcodeProblem {

    int alternateDigitSum(int _n) {
        int result = 0;
        int original = _n;
        int digits = 0;
        while (_n != 0) {
            _n /= 10;
            digits++;
        }
        boolean plus = digits % 2 != 0;
        while (original != 0) {
            int lastDigit = original % 10;
            if (plus) {
                result += lastDigit;
            } else {
                result -= lastDigit;
            }
            plus = !plus;
            original /= 10;
        }
        return result;
    }

}
