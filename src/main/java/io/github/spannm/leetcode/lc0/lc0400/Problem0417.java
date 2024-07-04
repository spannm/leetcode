package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0417 extends LeetcodeProblem {

    List<List<Integer>> pacificAtlantic(int[][] _matrix) {
        if (_matrix == null || _matrix.length == 0 || _matrix[0].length == 0) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();
        int nbRows = _matrix.length;
        int nbCols = _matrix[0].length;
        boolean[][] pacific = new boolean[nbRows][nbCols];
        boolean[][] atlantic = new boolean[nbRows][nbCols];

        for (int r = 0; r < nbRows; r++) {
            dfs(_matrix, pacific, Integer.MIN_VALUE, r, 0);
            dfs(_matrix, atlantic, Integer.MIN_VALUE, r, nbCols - 1);
        }

        for (int c = 0; c < nbCols; c++) {
            dfs(_matrix, pacific, Integer.MIN_VALUE, 0, c);
            dfs(_matrix, atlantic, Integer.MIN_VALUE, nbRows - 1, c);
        }

        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    static void dfs(int[][] _matrix, boolean[][] _visited, int _height, int _x, int _y) {
        int nbRows = _matrix.length;
        int nbCols = _matrix[0].length;
        if (_x < 0 || _y < 0 || _x >= nbRows || _y >= nbCols || _matrix[_x][_y] < _height || _visited[_x][_y]) {
            return;
        }
        _visited[_x][_y] = true;
        dfs(_matrix, _visited, _matrix[_x][_y], _x + 1, _y);
        dfs(_matrix, _visited, _matrix[_x][_y], _x, _y + 1);
        dfs(_matrix, _visited, _matrix[_x][_y], _x - 1, _y);
        dfs(_matrix, _visited, _matrix[_x][_y], _x, _y - 1);
    }

}
