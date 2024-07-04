package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2373. Largest Local Values in a Matrix.
 */
class Problem2373 extends LeetcodeProblem {

    int[][] largestLocal(int[][] _grid) {
        int len = _grid.length;
        int[][] result = new int[len - 2][len - 2];
        for (int i = 0; i < len - 2; i++) {
            for (int j = 0; j < len - 2; j++) {
                for (int x = i; x <= i + 2; x++) {
                    for (int y = j; y <= j + 2; y++) {
                        result[i][j] = Math.max(result[i][j], _grid[x][y]);
                    }
                }
            }
        }
        return result;
    }

}
