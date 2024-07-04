package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0723 extends LeetcodeProblem {

    int[][] candyCrush(int[][] _board) {
        int row = _board.length;
        int col = _board[0].length;
        boolean todo = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col - 2; j++) {
                int v = Math.abs(_board[i][j]);
                if (v != 0 && v == Math.abs(_board[i][j + 1]) && v == Math.abs(_board[i][j + 2])) {

                    _board[i][j] = _board[i][j + 1] = _board[i][j + 2] = -v;
                    todo = true;
                }
            }
        }

        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col; j++) {
                int v = Math.abs(_board[i][j]);
                if (v != 0 && v == Math.abs(_board[i + 1][j]) && v == Math.abs(_board[i + 2][j])) {
                    _board[i + 1][j] = _board[i + 2][j] = _board[i][j] = -v;
                    todo = true;
                }
            }
        }

        for (int j = 0; j < col; j++) {
            int wr = row - 1;
            for (int i = row - 1; i >= 0; i--) {
                if (_board[i][j] > 0) {
                    _board[wr--][j] = _board[i][j];
                }
            }
            while (wr >= 0) {
                _board[wr--][j] = 0;
            }
        }

        return todo ? candyCrush(_board) : _board;
    }

}
