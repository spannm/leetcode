package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeSet;

class Problem0363 extends LeetcodeProblem {

    int maxSumSubmatrix(int[][] _matrix, int _k) {
        int row = _matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = _matrix[0].length;
        int m = Math.min(row, col);
        int n = Math.max(row, col);

        boolean colIsBig = col > row;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] array = new int[n];

            for (int j = i; j >= 0; j--) {
                int val = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                for (int p = 0; p < n; p++) {
                    array[p] = array[p] + (colIsBig ? _matrix[j][p] : _matrix[p][j]);
                    val = val + array[p];

                    Integer subres = set.ceiling(val - _k);
                    if (null != subres) {
                        res = Math.max(res, val - subres);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }

}
