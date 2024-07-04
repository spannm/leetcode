package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix/">54. Spiral Matrix</a>.
 */
class Problem0054 extends LeetcodeProblem {

    static List<Integer> spiralOrder(int[][] _matrix) {
        final int nbRows = _matrix.length;
        final int nbCols = _matrix[0].length;

        final List<Integer> spiral = new ArrayList<>(nbRows * nbCols);

        int left = 0;
        int right = nbCols - 1;
        int top = 0;
        int bottom = nbRows - 1;

        while (left <= right && top <= bottom) {
            for (int x = left; x <= right; x++) {
                spiral.add(_matrix[top][x]);
            }
            top++;

            for (int y = top; y <= bottom; y++) {
                spiral.add(_matrix[y][right]);
            }
            right--;

            if (top <= bottom) {
                for (int x = right; x >= left; x--) {
                    spiral.add(_matrix[bottom][x]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int y = bottom; y >= top; y--) {
                    spiral.add(_matrix[y][left]);
                }
                left++;
            }
        }

        return spiral;
    }

}
