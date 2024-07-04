package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

class Problem1765 extends LeetcodeProblem {

    int[][] highestPeak(int[][] _isWater) {
        int m = _isWater.length;
        int n = _isWater[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (_isWater[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        int[] directions = new int[] {0, 1, 0, -1, 0};
        int height = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] curr = queue.poll();
                for (int i = 0; i < directions.length - 1; i++) {
                    int newx = directions[i] + curr[0];
                    int newy = directions[i + 1] + curr[1];
                    if (newx >= 0 && newx < m && newy >= 0 && newy < n && result[newx][newy] == 0) {
                        result[newx][newy] = height;
                        queue.offer(new int[] {newx, newy});
                    }
                }
            }
            height++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (_isWater[i][j] == 1) {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

}
