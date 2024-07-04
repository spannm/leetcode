package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0289 extends LeetcodeProblem {

    void gameOfLife(int[][] _board) {
        int height = _board.length;
        int width = _board[0].length;
        int[][] next = new int[height][width];
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

        for (int i = 0; i < _board.length; i++) {
            for (int j = 0; j < _board[0].length; j++) {
                int liveCellsCount = 0;

                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && y >= 0 && x < height && y < width && _board[x][y] == 1) {
                        liveCellsCount++;
                    }
                }

                if (_board[i][j] == 1) {
                    if (liveCellsCount <= 3 && liveCellsCount >= 2) {
                        next[i][j] = 1;
                    }
                } else if (_board[i][j] == 0) {
                    if (liveCellsCount == 3) {
                        next[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < _board.length; i++) {
            System.arraycopy(next[i], 0, _board[i], 0, _board[0].length);
        }
    }

}
