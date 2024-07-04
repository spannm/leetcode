package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/01-matrix/">542. 01 Matrix</a>.
 */
class Problem0542 extends LeetcodeProblem {

    int[][] updateMatrix(int[][] _matrix) {
        final int nbRows = _matrix.length;
        final int nbCols = _matrix[0].length;

        int[][] ret = new int[nbRows][nbCols];
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}};

        // first step iteration
        for (int row = 0; row < nbRows; row++) {
            for (int col = 0; col < nbCols; col++) {
                if (_matrix[row][col] == 0) {
                    ret[row][col] = 0;
                } else {
                    ret[row][col] = nbRows * nbCols;
                    for (int[] dir : dirs) {
                        int x = row + dir[0];
                        int y = col + dir[1];

                        // check if neighbor is valid
                        if (x < 0 || y < 0) {
                            continue;
                        }
                        ret[row][col] = Math.min(ret[row][col], ret[x][y]);
                    }
                    ret[row][col]++;
                }
            }
        }

        // second step iteration in reverse direction
        for (int row = nbRows - 1; row >= 0; row--) {
            for (int col = nbCols - 1; col >= 0; col--) {
                if (_matrix[row][col] == 0) {
                    ret[row][col] = 0;
                } else {
                    for (int[] dir : dirs) {
                        int x = row - dir[0];
                        int y = col - dir[1];

                        // check if neighbor is valid
                        if (x >= nbRows || y >= nbCols) {
                            continue;
                        }
                        ret[row][col] = Math.min(ret[row][col], ret[x][y] + 1);
                    }
                }
            }
        }
        return ret;
    }

}
