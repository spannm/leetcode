package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1275 extends LeetcodeProblem {

    String tictactoe(int[][] _moves) {
        String[][] board = new String[3][3];
        for (int i = 0; i < _moves.length; i++) {
            if (i % 2 == 0) {
                board[_moves[i][0]][_moves[i][1]] = "X";
            } else {
                board[_moves[i][0]][_moves[i][1]] = "O";
            }
            if (i > 3) {
                if (!wins(board).isEmpty()) {
                    return wins(board);
                }
            }
        }
        return _moves.length == 9 ? "Draw" : "Pending";
    }

    private String wins(String[][] _board) {

        for (int i = 0; i < 3; i++) {
            if (_board[i][0] == null) {
                break;
            }
            String str = _board[i][0];
            if (str.equals(_board[i][1]) && str.equals(_board[i][2])) {
                return getWinner(str);
            }
        }

        for (int j = 0; j < 3; j++) {
            if (_board[0][j] == null) {
                break;
            }
            String str = _board[0][j];
            if (str.equals(_board[1][j]) && str.equals(_board[2][j])) {
                return getWinner(str);
            }
        }

        if (_board[1][1] == null) {
            return "";
        }
        String str = _board[1][1];
        if (str.equals(_board[0][0]) && str.equals(_board[2][2]) || str.equals(_board[0][2]) && str.equals(_board[2][0])) {
            return getWinner(str);
        }
        return "";
    }

    private String getWinner(String _str) {
        if ("X".equals(_str)) {
            return "A";
        } else {
            return "B";
        }
    }

}
