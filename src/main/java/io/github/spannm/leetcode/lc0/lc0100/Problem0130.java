package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/surrounded-regions/">130. Surrounded Regions</a>.
 */
class Problem0130 extends LeetcodeProblem {

    void solve(char[][] _board) {
        int nbRows = _board.length;
        int nbCols = _board[0].length;
        if (nbCols == 0) {
            return;
        }

        final int[] dirs = new int[] {0, 1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();

        for (int c = 0; c < nbCols; c++) {
            if (_board[0][c] == 'O') {
                _board[0][c] = '+';
                queue.offer(new int[] {0, c});
            }
            if (_board[nbRows - 1][c] == 'O') {
                _board[nbRows - 1][c] = '+';
                queue.offer(new int[] {nbRows - 1, c});
            }
        }

        for (int r = 0; r < nbRows; r++) {
            if (_board[r][0] == 'O') {
                _board[r][0] = '+';
                queue.offer(new int[] {r, 0});
            }
            if (_board[r][nbCols - 1] == 'O') {
                _board[r][nbCols - 1] = '+';
                queue.offer(new int[] {r, nbCols - 1});
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dirs[i];
                int y = curr[1] + dirs[i + 1];
                if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && _board[x][y] == 'O') {
                    _board[x][y] = '+';
                    queue.offer(new int[] {x, y});
                }
            }
        }

        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (_board[i][j] == 'O') {
                    _board[i][j] = 'X';
                } else if (_board[i][j] == '+') {
                    _board[i][j] = 'O';
                }
            }
        }
    }

}
