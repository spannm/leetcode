package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1958. Check if Move is Legal.
 */
class Problem1958 extends LeetcodeProblem {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private static final int     N    = 8;

    boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        for (int[] d : DIRS) {
            int i = rMove;
            int j = cMove;
            int t = 0;
            int a = d[0];
            int b = d[1];
            while (0 <= i + a && i + a < N && 0 <= j + b && j + b < N) {
                t++;
                i += a;
                j += b;
                if (board[i][j] == '.' || board[i][j] == color) {
                    break;
                }
            }
            if (board[i][j] == color && t > 1) {
                return true;
            }
        }
        return false;
    }

}
