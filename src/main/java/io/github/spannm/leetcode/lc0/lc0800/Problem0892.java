package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0892 extends LeetcodeProblem {

    int surfaceArea(int[][] _grid) {
        int area = 0;
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        for (int[] value : _grid) {
            for (int c = 0; c < nbCols; c++) {
                if (value[c] != 0) {
                    area += value[c] * 4 + 2;
                }
            }
        }

        for (int[] ints : _grid) {
            for (int c = 0; c < nbCols - 1; c++) {
                if (ints[c] != 0 && ints[c + 1] != 0) {
                    area -= 2 * Math.min(ints[c], ints[c + 1]);
                }
            }
        }

        for (int r = 0; r < nbRows - 1; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_grid[r][c] != 0 && _grid[r + 1][c] != 0) {
                    area -= 2 * Math.min(_grid[r][c], _grid[r + 1][c]);
                }
            }
        }
        return area;
    }

}
