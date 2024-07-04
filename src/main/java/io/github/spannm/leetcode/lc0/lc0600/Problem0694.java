package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem0694 extends LeetcodeProblem {
    private static final int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int numDistinctIslands(int[][] _grid) {
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        Set<List<List<Integer>>> uqShapeIslands = new HashSet<>();
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                List<List<Integer>> island = new ArrayList<>();
                if (dfs(r, c, r, c, _grid, nbRows, nbCols, island)) {
                    uqShapeIslands.add(island);
                }
            }
        }
        return uqShapeIslands.size();
    }

    static boolean dfs(int _r1, int _c1, int _r2, int _c2, int[][] _grid, int _m, int _n, List<List<Integer>> _island) {
        if (_r2 < 0 || _c2 < 0 || _r2 >= _m || _c2 >= _n || _grid[_r2][_c2] <= 0) {
            return false;
        }
        _island.add(List.of(_r2 - _r1, _c2 - _c1));
        _grid[_r2][_c2] *= -1;
        for (int k = 0; k < 4; k++) {
            dfs(_r1, _c1, _r2 + DIRS[k][0], _c2 + DIRS[k][1], _grid, _m, _n, _island);
        }
        return true;
    }

}
