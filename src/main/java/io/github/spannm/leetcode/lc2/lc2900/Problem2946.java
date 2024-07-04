package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2946. Matrix Similarity After Cyclic Shifts.
 */
class Problem2946 extends LeetcodeProblem {

    boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k %= n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 1 && mat[i][j] != mat[i][(j + k) % n] || i % 2 == 0 && mat[i][j] != mat[i][(j - k + n) % n]) {
                    return false;
                }
            }
        }
        return true;
    }

}
