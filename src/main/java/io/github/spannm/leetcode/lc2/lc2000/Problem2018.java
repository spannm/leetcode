package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2018 extends LeetcodeProblem {

    boolean placeWordInCrossword(char[][] _board, String _word) {
        int m = _board.length;
        int n = _board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (_board[i][j] == ' ' || _board[i][j] == _word.charAt(0)) {
                    if (canPlaceTopDown(_word, _board, i, j) || canPlaceLeftRight(_word, _board, i, j)
                        || canPlaceBottomUp(_word, _board, i, j) || canPlaceRightLeft(_word, _board, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean canPlaceRightLeft(String _word, char[][] _board, int _row, int _col) {
        if (_col + 1 < _board[0].length && (Character.isLowerCase(_board[_row][_col + 1]) || _board[_row][_col + 1] == ' ')) {
            return false;
        }
        int k = 0;
        int j = _col;
        for (; j >= 0 && k < _word.length(); j--) {
            if (_board[_row][j] != _word.charAt(k) && _board[_row][j] != ' ') {
                return false;
            } else {
                k++;
            }
        }
        return k == _word.length() && (j < 0 || _board[_row][j] == '#');
    }

    private boolean canPlaceBottomUp(String _word, char[][] _board, int _row, int _col) {
        if (_row + 1 < _board.length && (Character.isLowerCase(_board[_row + 1][_col]) || _board[_row + 1][_col] == ' ')) {
            return false;
        }
        int k = 0;
        int i = _row;
        for (; i >= 0 && k < _word.length(); i--) {
            if (_board[i][_col] != _word.charAt(k) && _board[i][_col] != ' ') {
                return false;
            } else {
                k++;
            }
        }
        return k == _word.length() && (i < 0 || _board[i][_col] == '#');
    }

    private boolean canPlaceLeftRight(String _word, char[][] _board, int _row, int _col) {
        if (_col > 0 && (Character.isLowerCase(_board[_row][_col - 1]) || _board[_row][_col - 1] == ' ')) {
            return false;
        }
        int k = 0;
        int j = _col;
        for (; j < _board[0].length && k < _word.length(); j++) {
            if (_board[_row][j] != _word.charAt(k) && _board[_row][j] != ' ') {
                return false;
            } else {
                k++;
            }
        }
        return k == _word.length() && (j == _board[0].length || _board[_row][j] == '#');
    }

    private boolean canPlaceTopDown(String _word, char[][] _board, int _row, int _col) {
        if (_row > 0 && (Character.isLowerCase(_board[_row - 1][_col]) || _board[_row - 1][_col] == ' ')) {
            return false;
        }
        int k = 0;
        int i = _row;
        for (; i < _board.length && k < _word.length(); i++) {
            if (_board[i][_col] != _word.charAt(k) && _board[i][_col] != ' ') {
                return false;
            } else {
                k++;
            }
        }
        return k == _word.length() && (i == _board.length || _board[i][_col] == '#');
    }

}
