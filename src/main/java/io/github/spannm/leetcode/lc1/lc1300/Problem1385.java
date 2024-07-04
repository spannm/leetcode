package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1385 extends LeetcodeProblem {

    int findTheDistanceValue(int[] _arr1, int[] _arr2, int _d) {
        int count = 0;
        for (int element : _arr1) {
            int j = 0;
            for (; j < _arr2.length; j++) {
                if (Math.abs(element - _arr2[j]) <= _d) {
                    break;
                }
            }
            if (j == _arr2.length) {
                count++;
            }
        }
        return count;
    }

}
