package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/matrix-diagonal-sum/">1572. Matrix Diagonal Sum</a>.
 */
class Problem1572 extends LeetcodeProblem {

    static int diagonalSum(int[][] _matrix) {
        int sum = 0;
        int l = 0;
        int r = _matrix.length - 1;
        for (int[] line : _matrix) {
            sum += line[l];
            if (l != r) {
                sum += line[r];
            }
            l++;
            r--;
        }

        return sum;
    }

}
