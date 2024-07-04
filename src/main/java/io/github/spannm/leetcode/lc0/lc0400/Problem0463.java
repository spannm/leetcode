package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0463 extends LeetcodeProblem {

    int islandPerimeter(int[][] _grid) {
        int count = 0;
        for (int i = 0; i < _grid.length; i++) {
            for (int j = 0; j < _grid[0].length; j++) {
                if (_grid[i][j] == 1) {
                    count += 4;
                    if (i > 0 && _grid[i - 1][j] == 1) {
                        count -= 2;
                    }
                    if (j > 0 && _grid[i][j - 1] == 1) {
                        count -= 2;
                    }
                }
            }
        }
        return count;
    }

}
