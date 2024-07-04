package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

class Problem1030 extends LeetcodeProblem {

    int[][] allCellsDistOrder(int _r, int _c, int _r0, int _c0) {
        int[][] result = new int[_r * _c][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {_r0, _c0});
        boolean[][] visited = new boolean[_r][_c];
        int i = 0;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            if (row < 0 || row >= _r || col < 0 || col >= _c || visited[row][col]) {
                continue;
            }

            visited[row][col] = true;
            result[i++] = new int[] {row, col};
            queue.offer(new int[] {row, col + 1});
            queue.offer(new int[] {row + 1, col});
            queue.offer(new int[] {row - 1, col});
            queue.offer(new int[] {row, col - 1});

        }
        return result;
    }

}
