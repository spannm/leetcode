package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1304 extends LeetcodeProblem {

    int[] sumZero(int _n) {
        int[] result = new int[_n];
        int start = -_n / 2;
        for (int i = 0; i < _n / 2; i++) {
            result[i] = start++;
        }
        if (_n % 2 == 0) {
            start++;
        }
        for (int i = _n / 2; i < _n; i++) {
            result[i] = start++;
        }
        return result;
    }

}
