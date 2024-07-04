package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0976 extends LeetcodeProblem {

    int largestPerimeter(int[] _arr) {
        Arrays.sort(_arr);
        int len = _arr.length;

        for (int i = len - 1; i > 1; i--) {
            if (_arr[i] < _arr[i - 1] + _arr[i - 2]) {
                return _arr[i] + _arr[i - 1] + _arr[i - 2];
            }
        }

        return 0;
    }

}
