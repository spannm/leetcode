package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

class Problem1219 extends LeetcodeProblem {
    private static final int[] DIRS = new int[] {0, 1, 0, -1, 0};

    int getMaximumGold(int[][] _grid) {
        Queue<int[]> q = new LinkedList<>();
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (_grid[i][j] > 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int maxGold = 0;
        while (!q.isEmpty()) {
            int[] start = q.poll();
            boolean[][] visited = new boolean[nbRows][nbCols];
            visited[start[0]][start[1]] = true;
            maxGold = Math.max(maxGold, backtrack(_grid, start, _grid[start[0]][start[1]], visited));
        }
        return maxGold;
    }

    static int backtrack(int[][] _grid, int[] _start, int _gold, boolean[][] _visited) {
        int max = _gold;
        for (int i = 0; i < DIRS.length - 1; i++) {
            int nextX = _start[0] + DIRS[i];
            int nextY = _start[1] + DIRS[i + 1];
            if (nextX >= 0 && nextX < _grid.length && nextY >= 0 && nextY < _grid[0].length && !_visited[nextX][nextY] && _grid[nextX][nextY] > 0) {
                _visited[nextX][nextY] = true;
                max = Math.max(max, backtrack(_grid, new int[] {nextX, nextY}, _gold + _grid[nextX][nextY], _visited));
                _visited[nextX][nextY] = false;
            }
        }
        return max;
    }

}
