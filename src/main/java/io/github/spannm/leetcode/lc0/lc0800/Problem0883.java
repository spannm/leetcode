package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0883 extends LeetcodeProblem {

    int projectionArea(int[][] _grid) {
        int len = _grid.length;
        int area = 0;
        for (int r = 0; r < len; r++) {
            int x = 0;
            int y = 0;
            for (int c = 0; c < len; c++) {
                x = Math.max(x, _grid[r][c]);
                y = Math.max(x, _grid[c][r]);
                if (_grid[r][c] > 0) {
                    area++;
                }
            }
            area += x + y;
        }
        return area;
    }

}
