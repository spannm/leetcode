package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0885 extends LeetcodeProblem {
    protected int[][] spiralMatrixIII(int _r, int _c, int _r0, int _c0) {
        int[] directions = new int[] {0, 1, 0, -1, 0};
        int[][] result = new int[_r * _c][2];
        int i = 0;
        result[i++] = new int[] {_r0, _c0};
        int len = 0;
        int d = 0;
        while (i < _r * _c) {
            if (d == 0 || d == 2) {

                len++;
            }
            for (int k = 0; k < len; k++) {
                _r0 += directions[d];
                _c0 += directions[d + 1];
                if (_r0 >= 0 && _r0 < _r && _c0 >= 0 && _c0 < _c) {
                    result[i++] = new int[] {_r0, _c0};
                }
            }
            d = (d + 1) % 4;
        }
        return result;
    }

}
