package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/">2482. Difference Between
 * Ones and Zeros in Row and Column.</a>.
 */
class Problem2482 extends LeetcodeProblem {

    int[][] onesMinusZeros(int[][] _grid) {
        int rowCount = _grid.length;
        int colCount = _grid[0].length;
        int[] rows = new int[rowCount];
        int[] cols = new int[colCount];
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                int v = _grid[r][c];
                rows[r] += v;
                cols[c] += v;
            }
        }
        int[][] diff = new int[rowCount][colCount];
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                diff[r][c] = rows[r] + cols[c] - (colCount - rows[r]) - (rowCount - cols[c]);
            }
        }
        return diff;
    }

}
