package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1588 extends LeetcodeProblem {

    int sumOddLengthSubarrays(int[] _arr) {
        int sum = 0;
        for (int element : _arr) {
            sum += element;
        }
        int length = 3;
        while (length <= _arr.length) {
            for (int j = 0; j <= _arr.length - length; j++) {
                for (int i = j; i < j + length; i++) {
                    sum += _arr[i];
                }
            }
            length += 2;
        }
        return sum;
    }

}
