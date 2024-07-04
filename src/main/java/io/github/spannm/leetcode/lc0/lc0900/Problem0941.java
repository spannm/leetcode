package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0941 extends LeetcodeProblem {

    boolean validMountainArray(int[] _arr) {
        int i = 0;
        for (; i < _arr.length - 1; i++) {
            if (_arr[i] < _arr[i + 1]) {
                continue;
            } else if (_arr[i] == _arr[i + 1]) {
                return false;
            } else {
                break;
            }
        }
        if (i == 0 || i >= _arr.length - 1) {
            return false;
        }
        for (; i < _arr.length - 1; i++) {
            if (_arr[i] <= _arr[i + 1]) {
                return false;
            }
        }
        return i == _arr.length - 1;
    }

}
