package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem2160 extends LeetcodeProblem {

    int minimumSum(int _num) {
        int[] digits = new int[4];
        int i = 0;
        while (_num != 0) {
            digits[i++] = _num % 10;
            _num /= 10;
        }
        Arrays.sort(digits);
        int num1 = 0;
        if (digits[0] == 0) {
            num1 = digits[3];
        } else {
            num1 = digits[0] * 10 + digits[3];
        }
        int num2 = 0;
        if (digits[1] == 0) {
            num2 = digits[2];
        } else {
            num2 = digits[1] * 10 + digits[2];
        }
        return num1 + num2;
    }

}
