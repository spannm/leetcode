package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 794. Valid Tic-Tac-Toe State.
 */
class Problem0794 extends LeetcodeProblem {

    boolean validTicTacToe(String[] _board) {
        int x = count(_board, 'X');
        int o = count(_board, 'O');
        if (x != o && x - 1 != o || win(_board, 'X') && x - 1 != o) {
            return false;
        }
        return !(win(_board, 'O') && x != o);
    }

    static boolean win(String[] _board, char _x) {
        for (int i = 0; i < 3; i++) {
            if ((_board[i].charAt(0) == _x && _board[i].charAt(1) == _x && _board[i].charAt(2) == _x)
             || (_board[0].charAt(i) == _x && _board[1].charAt(i) == _x && _board[2].charAt(i) == _x)) {
                return true;
            }
        }
        return (_board[0].charAt(0) == _x && _board[1].charAt(1) == _x && _board[2].charAt(2) == _x)
            || (_board[0].charAt(2) == _x && _board[1].charAt(1) == _x && _board[2].charAt(0) == _x);
    }

    static int count(String[] _board, char _x) {
        int count = 0;
        for (String row : _board) {
            for (char c : row.toCharArray()) {
                if (c == _x) {
                    count++;
                }
            }
        }
        return count;
    }

}
