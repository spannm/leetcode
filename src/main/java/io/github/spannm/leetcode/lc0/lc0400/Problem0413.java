package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0413 extends LeetcodeProblem {

    int numberOfArithmeticSlices(int[] _arr) {
        int sum = 0;
        int len = 2;
        for (int i = 2; i < _arr.length; i++) {
            if (_arr[i] - _arr[i - 1] == _arr[i - 1] - _arr[i - 2]) {
                len++;
            } else {
                if (len > 2) {
                    sum += calculateSlices(len);
                }
                len = 2;
            }
        }
        if (len > 2) {
            sum += calculateSlices(len);
        }
        return sum;
    }

    int calculateSlices(int _len) {
        return (_len - 1) * (_len - 2) / 2;
    }

}
