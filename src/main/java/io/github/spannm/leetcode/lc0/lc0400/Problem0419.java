package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0419 extends LeetcodeProblem {

    int countBattleships(char[][] _board) {
        if (_board == null || _board.length == 0) {
            return 0;
        }
        int nbRows = _board.length;
        int nbCols = _board[0].length;
        int count = 0;
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if ((_board[r][c] == '.' || c > 0 && _board[r][c - 1] == 'X')
                    || r > 0 && _board[r - 1][c] == 'X') {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

}
