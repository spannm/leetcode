package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1914. Cyclically Rotating a Grid.
 */
class Problem1914 extends LeetcodeProblem {

    private int[][] grid;
    private int     nbRows;
    private int     nbCols;

    int[][] rotateGrid(int[][] _grid, int _k) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        for (int p = 0; p < Math.min(nbRows, nbCols) / 2; p++) {
            rotate(p, _k);
        }
        return _grid;
    }

    private void rotate(int _p, int _k) {
        List<Integer> nums = new ArrayList<>();
        for (int c = _p; c < nbCols - _p - 1; c++) {
            nums.add(grid[_p][c]);
        }
        for (int r = _p; r < nbRows - _p - 1; r++) {
            nums.add(grid[r][nbCols - _p - 1]);
        }
        for (int c = nbCols - _p - 1; c > _p; c--) {
            nums.add(grid[nbRows - _p - 1][c]);
        }
        for (int r = nbRows - _p - 1; r > _p; r--) {
            nums.add(grid[r][_p]);
        }
        int l = nums.size();
        _k %= l;
        if (_k == 0) {
            return;
        }
        for (int c = _p; c < nbCols - _p - 1; c++) {
            grid[_p][c] = nums.get(_k++ % l);
        }
        for (int r = _p; r < nbRows - _p - 1; r++) {
            grid[r][nbCols - _p - 1] = nums.get(_k++ % l);
        }
        for (int c = nbCols - _p - 1; c > _p; c--) {
            grid[nbRows - _p - 1][c] = nums.get(_k++ % l);
        }
        for (int r = nbRows - _p - 1; r > _p; r--) {
            grid[r][_p] = nums.get(_k++ % l);
        }
    }

}
