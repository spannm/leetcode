package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0361 extends LeetcodeProblem {

    int maxKilledEnemies(char[][] _grid) {
        int nbRows = _grid.length;
        if (nbRows == 0) {
            return 0;
        }
        int nbCols = _grid[0].length;

        int[][] max = new int[nbRows][nbCols];

        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {

                if (_grid[r][c] == '0') {
                    int count = 0;

                    for (int k = c - 1; k >= 0; k--) {
                        if (_grid[r][k] == 'E') {
                            count++;
                        } else if (_grid[r][k] == 'W') {
                            break;
                        }
                    }

                    for (int k = c + 1; k < nbCols; k++) {
                        if (_grid[r][k] == 'E') {
                            count++;
                        } else if (_grid[r][k] == 'W') {
                            break;
                        }
                    }

                    for (int k = r + 1; k < nbRows; k++) {
                        if (_grid[k][c] == 'E') {
                            count++;
                        } else if (_grid[k][c] == 'W') {
                            break;
                        }
                    }

                    for (int k = r - 1; k >= 0; k--) {
                        if (_grid[k][c] == 'E') {
                            count++;
                        } else if (_grid[k][c] == 'W') {
                            break;
                        }
                    }

                    max[r][c] = count;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (max[i][j] > result) {
                    result = max[i][j];
                }
            }
        }
        return result;
    }

}
