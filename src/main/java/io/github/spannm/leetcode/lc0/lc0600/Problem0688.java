package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/knight-probability-in-chessboard/">688. Knight Probability in Chessboard</a>.
 */
class Problem0688 extends LeetcodeProblem {

    double knightProbability(final int _n, final int _k, final int _row, final int _col) {
        final int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        final double moveCount = moves.length;

        double[][] currBoard;
        double[][] nextBoard = new double[_n][_n];
        nextBoard[_row][_col] = 1.0;

        for (int i = 0; i < _k; i++) {
            currBoard = nextBoard;
            nextBoard = new double[_n][_n];

            for (int r = 0; r < _n; r++) {
                for (int c = 0; c < _n; c++) {
                    if (currBoard[r][c] == 0.0) {
                        continue;
                    }

                    for (int[] dir : moves) {
                        int nextRow = r + dir[0];
                        int nextCol = c + dir[1];

                        if (nextRow >= 0 && nextRow < _n && nextCol >= 0 && nextCol < _n) {
                            nextBoard[nextRow][nextCol] += currBoard[r][c] / moveCount;
                        }
                    }
                }
            }
        }

        double total = 0.0;
        for (int r = 0; r < _n; r++) {
            for (int c = 0; c < _n; c++) {
                total += nextBoard[r][c];
            }
        }

        currBoard = null;
        nextBoard = null;
        System.gc();

        return total;
    }

}
