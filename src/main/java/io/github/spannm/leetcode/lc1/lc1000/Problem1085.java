package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1085 extends LeetcodeProblem {

    int sumOfDigits(int[] _arr) {
        int smallestNumber = _arr[0];
        for (int i = 1; i < _arr.length; i++) {
            smallestNumber = Math.min(smallestNumber, _arr[i]);
        }
        int sum = 0;
        while (smallestNumber > 0) {
            sum += smallestNumber % 10;
            smallestNumber /= 10;
        }
        return sum % 2 == 0 ? 1 : 0;
    }

}
