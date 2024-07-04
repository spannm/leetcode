package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0999 extends LeetcodeProblem {
    private static final int[] DIRS = new int[] {0, 1, 0, -1, 0};

    int numRookCaptures(char[][] _board) {
        int nbRows = _board.length;
        int nbCols = _board[0].length;
        int rowR = -1;
        int colR = -1;
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_board[r][c] == 'R') {
                    rowR = r;
                    colR = c;
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int neighborRow = rowR + DIRS[i];
            int neighborCol = colR + DIRS[i + 1];
            if (neighborRow >= 0 && neighborRow < nbRows
                && neighborCol >= 0 && neighborCol < nbCols
                && _board[neighborRow][neighborCol] != 'B') {
                if (DIRS[i] == 0 && DIRS[i + 1] == 1) {
                    while (neighborCol < nbCols) {
                        if (_board[neighborRow][neighborCol] == 'p') {
                            count++;
                            break;
                        } else if (_board[neighborRow][neighborCol] == 'B') {
                            break;
                        } else {
                            neighborCol++;
                        }
                    }
                } else if (DIRS[i] == 1 && DIRS[i + 1] == 0) {
                    while (neighborRow < nbRows) {
                        if (_board[neighborRow][neighborCol] == 'p') {
                            count++;
                            break;
                        } else if (_board[neighborRow][neighborCol] == 'B') {
                            break;
                        } else {
                            neighborRow++;
                        }
                    }
                } else if (DIRS[i] == 0 && DIRS[i + 1] == -1) {
                    while (neighborCol >= 0) {
                        if (_board[neighborRow][neighborCol] == 'p') {
                            count++;
                            break;
                        } else if (_board[neighborRow][neighborCol] == 'B') {
                            break;
                        } else {
                            neighborCol--;
                        }
                    }
                } else {
                    while (neighborRow >= 0) {
                        if (_board[neighborRow][neighborCol] == 'p') {
                            count++;
                            break;
                        } else if (_board[neighborRow][neighborCol] == 'B') {
                            break;
                        } else {
                            neighborRow--;
                        }
                    }
                }
            }
        }

        return count;
    }

}
