package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem1992 extends LeetcodeProblem {

    int[][] findFarmland(int[][] _land) {
        int rows = _land.length;
        int cols = _land[0].length;
        int[] dirs = new int[] {0, 1, 0, -1, 0};
        int dirCount = dirs.length;
        List<int[]> farms = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (_land[r][c] != 1 || visited[r][c]) {
                    continue;
                }

                visited[r][c] = true;
                q.offer(new int[] {r, c});
                int[] coords = new int[] {r, c, r, c};
                while (!q.isEmpty()) {
                    int qsz = q.size();
                    for (int k = 0; k < qsz; k++) {
                        int[] curr = q.poll();
                        for (int p = 0; p < dirCount - 1; p++) {
                            int newX = dirs[p] + curr[0];
                            int newY = dirs[p + 1] + curr[1];
                            if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && _land[newX][newY] == 1 && !visited[newX][newY]) {
                                visited[newX][newY] = true;
                                q.offer(new int[] {newX, newY});
                                coords[0] = Math.min(coords[0], newX);
                                coords[1] = Math.min(coords[1], newY);
                                coords[2] = Math.max(coords[2], newX);
                                coords[3] = Math.max(coords[3], newY);
                            }
                        }
                    }
                }
                farms.add(coords);
                q.clear();
            }
        }
        int[][] result = new int[farms.size()][4];
        for (int i = 0; i < farms.size(); i++) {
            System.arraycopy(farms.get(i), 0, result[i], 0, farms.get(i).length);
        }
        return result;
    }

}
