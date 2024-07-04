package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/rotate-image/">48. Rotate Image</a>.
 */
class Problem0048 extends LeetcodeProblem {

    void rotate(int[][] _matrix) {
        int rows = _matrix.length;
        int cols = _matrix[0].length;
        int top = 0;
        int bottom = cols - 1;
        while (top < bottom) {
            int[] tmp = _matrix[top];
            _matrix[top] = _matrix[bottom];
            _matrix[bottom] = tmp;
            top++;
            bottom--;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int tmp = _matrix[i][j];
                _matrix[i][j] = _matrix[j][i];
                _matrix[j][i] = tmp;
            }
        }
    }

}
