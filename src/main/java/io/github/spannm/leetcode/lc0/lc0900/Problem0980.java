package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0980 extends LeetcodeProblem {

    private static final int[] DIRS  = new int[] {0, 1, 0, -1, 0};
    private int                paths = 0;

    int uniquePathsIII(int[][] _grid) {
        int[] start = findStart(_grid);
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        boolean[][] visited = new boolean[nbRows][nbCols];
        visited[start[0]][start[1]] = true;
        return backtrack(_grid, nbRows, nbCols, visited, start);
    }

    int backtrack(int[][] _grid, int _m, int _n, boolean[][] _visited, int[] _start) {
        for (int i = 0; i < DIRS.length - 1; i++) {
            int nextX = DIRS[i] + _start[0];
            int nextY = DIRS[i + 1] + _start[1];
            if (nextX >= 0 && nextX < _m && nextY >= 0 && nextY < _n && _grid[nextX][nextY] != -1 && !_visited[nextX][nextY]) {
                if (_grid[nextX][nextY] == 2) {
                    if (allZeroesVisited(_visited, _grid)) {
                        paths++;
                        return paths;
                    } else {
                        continue;
                    }
                }
                _visited[nextX][nextY] = true;
                backtrack(_grid, _m, _n, _visited, new int[] {nextX, nextY});
                _visited[nextX][nextY] = false;
            }
        }
        return paths;
    }

    static boolean allZeroesVisited(boolean[][] _visited, int[][] _grid) {
        for (int i = 0; i < _grid.length; i++) {
            for (int j = 0; j < _grid[0].length; j++) {
                if (_grid[i][j] == 0 && !_visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static int[] findStart(int[][] _grid) {
        for (int i = 0; i < _grid.length; i++) {
            for (int j = 0; j < _grid[0].length; j++) {
                if (_grid[i][j] == 1) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

}
