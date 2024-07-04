package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

class Problem0317 extends LeetcodeProblem {

    int shortestDistance(int[][] _grid) {
        int nbRows = _grid.length;
        if (nbRows == 0) {
            return -1;
        }
        int nbCols = _grid[0].length;
        int[][] reach = new int[nbRows][nbCols];
        int[][] distance = new int[nbRows][nbCols];
        int[] shift = new int[] {0, 1, 0, -1, 0};
        int numBuilding = 0;

        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                if (_grid[r][c] == 1) {
                    numBuilding++;
                    int dist = 1;
                    boolean[][] visited = new boolean[nbRows][nbCols];

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {r, c});
                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int l = 0; l < size; l++) {
                            int[] current = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nextRow = current[0] + shift[k];
                                int nextCol = current[1] + shift[k + 1];
                                if (nextRow >= 0
                                    && nextRow < nbRows
                                    && nextCol >= 0
                                    && nextCol < nbCols
                                    && !visited[nextRow][nextCol]
                                    && _grid[nextRow][nextCol] == 0) {
                                    distance[nextRow][nextCol] += dist;
                                    visited[nextRow][nextCol] = true;
                                    reach[nextRow][nextCol]++;
                                    q.offer(new int[] {nextRow, nextCol});
                                }
                            }
                        }
                        dist++;
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (_grid[i][j] == 0 && reach[i][j] == numBuilding && distance[i][j] < result) {
                    result = distance[i][j];
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
