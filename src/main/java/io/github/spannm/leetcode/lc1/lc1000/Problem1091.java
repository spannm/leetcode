package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/description/"> 1091. Shortest Path in Binary
 * Matrix</a>.
 */
class Problem1091 extends LeetcodeProblem {

    int shortestPathBinaryMatrix(int[][] _grid) {
        final int rowCount = _grid.length;
        final int colCount = _grid[0].length;

        if (_grid[0][0] == 1 || _grid[rowCount - 1][colCount - 1] == 1) {
            return -1;
        }

        final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

        final Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        int pathLen = 1;

        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                int[] curr = q.poll();
                if (curr[0] == rowCount - 1 && curr[1] == colCount - 1) {
                    return pathLen;
                }
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < rowCount && y >= 0 && y < colCount && _grid[x][y] == 0) {
                        q.add(new int[] {x, y});
                        _grid[x][y] = 1;
                    }
                }
            }
            pathLen++;
        }

        return -1;
    }

}
