package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0840 extends LeetcodeProblem {

    int numMagicSquaresInside(int[][] _grid) {
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        int count = 0;
        for (int r = 0; r < nbRows - 2; r++) {
            for (int c = 0; c < nbCols - 2; c++) {
                Set<Integer> set = new HashSet<>();
                int sum = _grid[r][c] + _grid[r][c + 1] + _grid[r][c + 2];
                if (sum == _grid[r + 1][c] + _grid[r + 1][c + 1] + _grid[r + 1][c + 2]
                    && sum == _grid[r + 2][c] + _grid[r + 2][c + 1] + _grid[r + 2][c + 2]

                    && sum == _grid[r][c] + _grid[r + 1][c] + _grid[r + 2][c]
                    && sum == _grid[r][c + 1] + _grid[r + 1][c + 1] + _grid[r + 2][c + 1]
                    && sum == _grid[r][c + 2] + _grid[r + 1][c + 2] + _grid[r + 2][c + 2]

                    && sum == _grid[r][c] + _grid[r + 1][c + 1] + _grid[r + 2][c + 2]
                    && sum == _grid[r][c + 2] + _grid[r + 1][c + 1] + _grid[r + 2][c]

                    && set.add(_grid[r][c]) && isLegit(_grid[r][c])
                    && set.add(_grid[r][c + 1]) && isLegit(_grid[r][c + 1])
                    && set.add(_grid[r][c + 2]) && isLegit(_grid[r][c + 2])
                    && set.add(_grid[r + 1][c]) && isLegit(_grid[r + 1][c])
                    && set.add(_grid[r + 1][c + 1]) && isLegit(_grid[r + 1][c + 1])
                    && set.add(_grid[r + 1][c + 2]) && isLegit(_grid[r + 1][c + 2])
                    && set.add(_grid[r + 2][c]) && isLegit(_grid[r + 2][c])
                    && set.add(_grid[r + 2][c + 1]) && isLegit(_grid[r + 2][c + 1])
                    && set.add(_grid[r + 2][c + 2]) && isLegit(_grid[r + 2][c + 2])) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isLegit(int _num) {
        return _num <= 9 && _num >= 1;
    }

}
