package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/path-with-minimum-effort/">1631. Path With Minimum Effort</a>.
 */
class Problem1631 extends LeetcodeProblem {

    private int rowCount = 0;
    private int colCount = 0;

    int minimumEffortPath(int[][] _heights) {
        rowCount = _heights.length;
        colCount = _heights[0].length;

        int l = 0;
        int r = 1_000_000;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (dfs(_heights, 0, 0, _heights[0][0], m, new boolean[rowCount][colCount])) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean dfs(int[][] _heights, int _i, int _j, int _prev, int _limit, boolean[][] _visited) {
        if (_i < 0 || _i >= rowCount || _j < 0 || _j >= colCount
            || _visited[_i][_j] || Math.abs(_heights[_i][_j] - _prev) > _limit) {
            return false;
        }
        _visited[_i][_j] = true;
        return _i == rowCount - 1 && _j == colCount - 1
            || dfs(_heights, _i - 1, _j, _heights[_i][_j], _limit, _visited)
            || dfs(_heights, _i + 1, _j, _heights[_i][_j], _limit, _visited)
            || dfs(_heights, _i, _j - 1, _heights[_i][_j], _limit, _visited)
            || dfs(_heights, _i, _j + 1, _heights[_i][_j], _limit, _visited);
    }

}
