package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix-ii/">59. Spiral Matrix II</a>.
 */
class Problem0059 extends LeetcodeProblem {

    int[][] generateMatrix(final int _size) {
        final int nbRows = _size;
        final int nbCols = _size;
        final int[][] matrix = new int[nbRows][nbCols];

        int num = 0;
        int left = 0;
        int right = nbCols - 1;
        int top = 0;
        int bottom = nbRows - 1;

        while (left <= right && top <= bottom) {
            for (int x = left; x <= right; x++) {
                matrix[top][x] = ++num;
            }
            top++;

            for (int y = top; y <= bottom; y++) {
                matrix[y][right] = ++num;
            }
            right--;

            if (top <= bottom) {
                for (int x = right; x >= left; x--) {
                    matrix[bottom][x] = ++num;
                }
                bottom--;
            }

            if (left <= right) {
                for (int y = bottom; y >= top; y--) {
                    matrix[y][left] = ++num;
                }
                left++;
            }
        }

        return matrix;
    }

}
