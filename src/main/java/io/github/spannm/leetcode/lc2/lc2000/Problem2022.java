package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2022 extends LeetcodeProblem {

    int[][] construct2DArray(int[] _original, int _m, int _n) {
        int size = _original.length;
        if (_m * _n != size) {
            return new int[][] {};
        }
        int[][] ans = new int[_m][_n];
        int k = 0;
        for (int i = 0; i < _m; i++) {
            for (int j = 0; j < _n; j++) {
                ans[i][j] = _original[k++];
            }
        }
        return ans;
    }

}
