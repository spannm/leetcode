package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/last-day-where-you-can-still-cross/">1970. Last Day Where You Can Still
 * Cross</a>.
 * <p>
 * See
 * <a href="https://leetcode.com/problems/last-day-where-you-can-still-cross/solutions/3698497/easy-but-not-fast/">this
 * nice solution</a>.
 */
class Problem1970 extends LeetcodeProblem {

    int latestDayToCross(int _rows, int _cols, int[][] _cells) {
        final int[][] grid = new int[_rows][_cols];
        final int days = _cells.length;
        for (int day = 0; day < days; day++) {
            grid[_cells[day][0] - 1][_cells[day][1] - 1] = day + 1;
        }

        int low = 0;
        int high = days;
        int ans = -1;

        while (low < high) {
            int day = high - (high - low) / 2;
            boolean isWay = false;
            for (int y = 0; y < _cols && !isWay; y++) {
                boolean[][] tgrid = new boolean[_rows][_cols];
                isWay = isWay || check(0, y, _rows, _cols, grid, day, tgrid);
            }
            if (isWay) {
                low = day;
                ans = day;
            } else {
                high = day - 1;
            }
        }
        return ans;
    }

    static boolean check(int _x, int _y, int _rows, int _cols, int[][] _grid, int _day, boolean[][] _tgrid) {
        if (_x < 0 || _y < 0 || _x >= _rows || _y >= _cols || _grid[_x][_y] <= _day || _tgrid[_x][_y]) {
            return false;
        }
        _tgrid[_x][_y] = true;
        return _x == _rows - 1
            || check(_x + 1, _y, _rows, _cols, _grid, _day, _tgrid)
            || check(_x, _y + 1, _rows, _cols, _grid, _day, _tgrid)
            || check(_x - 1, _y, _rows, _cols, _grid, _day, _tgrid)
            || check(_x, _y - 1, _rows, _cols, _grid, _day, _tgrid);
    }

}
