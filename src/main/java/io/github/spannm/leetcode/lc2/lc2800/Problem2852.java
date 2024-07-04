package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2852. Sum of Remoteness of All Cells.
 */
class Problem2852 extends LeetcodeProblem {

    private static final int[] DIRS = {-1, 0, 1, 0, -1};
    private int[][]            grid;
    private int                len;

    long sumRemoteness(int[][] _grid) {
        grid = _grid;
        len = _grid.length;
        int cnt = 0;
        for (int[] row : _grid) {
            for (int x : row) {
                if (x > 0) {
                    cnt++;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (_grid[i][j] > 0) {
                    long[] res = dfs(i, j);
                    ans += (cnt - res[1]) * res[0];
                }
            }
        }
        return ans;
    }

    private long[] dfs(int _i, int _j) {
        long[] res = new long[2];
        res[0] = grid[_i][_j];
        res[1] = 1;
        grid[_i][_j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = _i + DIRS[k];
            int y = _j + DIRS[k + 1];
            if (x >= 0 && x < len && y >= 0 && y < len && grid[x][y] > 0) {
                long[] tmp = dfs(x, y);
                res[0] += tmp[0];
                res[1] += tmp[1];
            }
        }
        return res;
    }

}
