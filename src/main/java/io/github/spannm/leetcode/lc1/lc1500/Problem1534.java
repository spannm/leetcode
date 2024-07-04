package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1534 extends LeetcodeProblem {

    int countGoodTriplets(int[] _arr, int _a, int _b, int _c) {
        int count = 0;
        for (int i = 0; i < _arr.length - 2; i++) {
            for (int j = i + 1; j < _arr.length - 1; j++) {
                for (int k = j + 1; k < _arr.length; k++) {
                    if (Math.abs(_arr[i] - _arr[j]) <= _a && Math.abs(_arr[j] - _arr[k]) <= _b && Math.abs(_arr[i] - _arr[k]) <= _c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
