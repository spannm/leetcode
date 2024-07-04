package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1287 extends LeetcodeProblem {

    int findSpecialInteger(int[] _arr) {
        int quarter = _arr.length / 4;
        for (int i = 0; i < _arr.length - quarter; i++) {
            if (_arr[i] == _arr[i + quarter]) {
                return _arr[i];
            }
        }
        return -1;
    }

}
