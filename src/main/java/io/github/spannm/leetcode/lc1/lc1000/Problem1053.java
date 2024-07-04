package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1053. Previous Permutation With One Swap.
 */
class Problem1053 extends LeetcodeProblem {

    int[] prevPermOpt1(int[] _arr) {
        int n = _arr.length;
        for (int i = n - 1; i > 0; i--) {
            if (_arr[i - 1] > _arr[i]) {
                for (int j = n - 1; j > i - 1; j--) {
                    if (_arr[j] < _arr[i - 1] && _arr[j] != _arr[j - 1]) {
                        int t = _arr[i - 1];
                        _arr[i - 1] = _arr[j];
                        _arr[j] = t;
                        return _arr;
                    }
                }
            }
        }
        return _arr;
    }

}
