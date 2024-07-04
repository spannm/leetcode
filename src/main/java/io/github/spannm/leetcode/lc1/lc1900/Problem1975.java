package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1975. Maximum Matrix Sum.
 */
class Problem1975 extends LeetcodeProblem {

    long maxMatrixSum(int[][] matrix) {
        long s = 0;
        int cnt = 0;
        int mi = Integer.MAX_VALUE;
        for (var row : matrix) {
            for (var v : row) {
                s += Math.abs(v);
                mi = Math.min(mi, Math.abs(v));
                if (v < 0) {
                    cnt++;
                }
            }
        }
        if (cnt % 2 == 0 || mi == 0) {
            return s;
        }
        return s - mi * 2;
    }

}
