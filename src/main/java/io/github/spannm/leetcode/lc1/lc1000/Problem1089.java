package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1089 extends LeetcodeProblem {

    void duplicateZeros(int[] _arr) {
        for (int i = 0; i < _arr.length - 1; i++) {
            if (_arr[i] == 0) {
                duplicateZeros(_arr, i + 1);
                i++;
            }
        }
    }

    private void duplicateZeros(int[] _arr, int _zeroIndex) {
        int tmp = _arr[_zeroIndex];
        _arr[_zeroIndex] = 0;
        for (int i = _zeroIndex + 1; i < _arr.length; i++) {
            int next = _arr[i];
            _arr[i] = tmp;
            tmp = next;
        }
    }

}
