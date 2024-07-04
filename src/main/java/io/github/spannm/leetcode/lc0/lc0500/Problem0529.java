package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 529. Minesweeper.
 */
class Problem0529 extends LeetcodeProblem {

    private char[][] board;
    private int      nbRows;
    private int      nbCols;

    char[][] updateBoard(char[][] _board, int[] _click) {
        nbRows = _board.length;
        nbCols = _board[0].length;
        board = _board;
        int x = _click[0];
        int y = _click[1];
        if (_board[x][y] == 'M') {
            _board[x][y] = 'X';
        } else {
            dfs(x, y);
        }
        return _board;
    }

    private void dfs(int _x, int _y) {
        int cnt = 0;
        for (int x = _x - 1; x <= _x + 1; x++) {
            for (int y = _y - 1; y <= _y + 1; y++) {
                if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && board[x][y] == 'M') {
                    cnt++;
                }
            }
        }
        if (cnt > 0) {
            board[_x][_y] = (char) (cnt + '0');
        } else {
            board[_x][_y] = 'B';
            for (int x = _x - 1; x <= _x + 1; x++) {
                for (int y = _y - 1; y <= _y + 1; y++) {
                    if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && board[x][y] == 'E') {
                        dfs(x, y);
                    }
                }
            }
        }
    }

}
