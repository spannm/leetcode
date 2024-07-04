package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1134 extends LeetcodeProblem {

    boolean isArmstrong(int _n) {
        int numOfDigits = 0;
        int copyN = _n;
        while (copyN > 0) {
            copyN /= 10;
            numOfDigits++;
        }
        int sum = 0;
        copyN = _n;
        while (_n > 0) {
            int digit = _n % 10;
            sum += Math.pow(digit, numOfDigits);
            _n /= 10;
        }
        return sum == copyN;
    }

}
