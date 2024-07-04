package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1004 extends LeetcodeProblem {

    int longestOnes(int[] _arr, int _k) {
        int result = 0;
        int i = 0;
        for (int j = 0; j < _arr.length; j++) {
            if (_arr[j] == 0) {
                _k--;
            }
            while (_k < 0) {
                if (_arr[i] == 0) {
                    _k++;
                }
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }

}
