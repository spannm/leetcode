package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0329 extends LeetcodeProblem {

    private static final int[] DIRS = new int[] {0, 1, 0, -1, 0};

    int longestIncreasingPath(int[][] _matrix) {
        int nbRows = _matrix.length;
        int nbCols = _matrix[0].length;
        int max = 0;
        int[][] cache = new int[nbRows][nbCols];
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                int len = dfs(_matrix, r, c, cache);
                max = Math.max(len, max);
            }
        }
        return max;
    }

    static int dfs(int[][] _matrix, int _row, int _col, int[][] _cache) {
        if (_cache[_row][_col] != 0) {
            return _cache[_row][_col];
        }
        int max = 1;
        for (int i = 0; i < DIRS.length - 1; i++) {
            int nextRow = _row + DIRS[i];
            int nextCol = _col + DIRS[i + 1];
            if (nextRow < 0 || nextRow >= _matrix.length || nextCol < 0 || nextCol >= _matrix[0].length || _matrix[nextRow][nextCol] <= _matrix[_row][_col]) {
                continue;
            }
            int len = 1 + dfs(_matrix, nextRow, nextCol, _cache);
            max = Math.max(max, len);
        }
        _cache[_row][_col] = max;
        return max;
    }

}
