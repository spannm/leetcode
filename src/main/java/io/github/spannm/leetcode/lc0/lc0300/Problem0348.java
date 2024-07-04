package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0348 extends LeetcodeProblem {

    static class TicTacToe {

        private int         diagonal;

        private int         antidiagonal;
        private final int[] rows;
        private final int[] cols;

        TicTacToe(int _n) {
            rows = new int[_n];
            cols = new int[_n];
        }

        int move(int _row, int _col, int _player) {
            int toAdd = _player == 1 ? 1 : -1;

            rows[_row] += toAdd;
            cols[_col] += toAdd;
            int size = rows.length;

            if (_row == _col) {
                diagonal += toAdd;
            }
            if (_col == size - _row - 1) {
                antidiagonal += toAdd;
            }

            if (Math.abs(rows[_row]) == size
                || Math.abs(cols[_col]) == size
                || Math.abs(antidiagonal) == size
                || Math.abs(diagonal) == size) {
                return _player;
            }

            return 0;
        }
    }

}
