package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1524 extends LeetcodeProblem {

    int numOfSubarrays(int[] _arr) {
        final int len = _arr.length;
        long oddCount = 0;
        for (int i = 0; i < len; i++) {
            long subTotal = 0;
            for (int j = i; j < len; j++) {
                subTotal += _arr[j];
                if (subTotal % 2 != 0) {
                    oddCount++;
                }
            }
        }
        return (int) oddCount % 1000000007;
    }

}
