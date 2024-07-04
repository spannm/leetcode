package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2617. Minimum Number of Visited Cells in a Grid.
 */
class Problem2617 extends LeetcodeProblem {

    int minimumVisitedCells(int[][] _grid) {
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        int[][] dist = new int[nbRows][nbCols];
        @SuppressWarnings("unchecked")
        Queue<int[]>[] rows = new PriorityQueue[nbRows];
        @SuppressWarnings("unchecked")
        Queue<int[]>[] cols = new PriorityQueue[nbCols];
        for (int r = 0; r < nbRows; r++) {
            Arrays.fill(dist[r], -1);
            rows[r] = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        }
        for (int c = 0; c < nbCols; c++) {
            cols[c] = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        }
        dist[0][0] = 1;
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                while (!rows[r].isEmpty() && _grid[r][rows[r].peek()[1]] + rows[r].peek()[1] < c) {
                    rows[r].poll();
                }
                if (!rows[r].isEmpty() && (dist[r][c] == -1 || rows[r].peek()[0] + 1 < dist[r][c])) {
                    dist[r][c] = rows[r].peek()[0] + 1;
                }
                while (!cols[c].isEmpty() && _grid[cols[c].peek()[1]][c] + cols[c].peek()[1] < r) {
                    cols[c].poll();
                }
                if (!cols[c].isEmpty() && (dist[r][c] == -1 || cols[c].peek()[0] + 1 < dist[r][c])) {
                    dist[r][c] = cols[c].peek()[0] + 1;
                }
                if (dist[r][c] != -1) {
                    rows[r].offer(new int[] {dist[r][c], c});
                    cols[c].offer(new int[] {dist[r][c], r});
                }
            }
        }
        return dist[nbRows - 1][nbCols - 1];
    }

}
