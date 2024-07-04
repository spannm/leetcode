package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0807 extends LeetcodeProblem {

    int maxIncreaseKeepingSkyline(int[][] _grid) {
        int size = _grid.length;
        int[] horizontalLimits = new int[size];
        int[] verticalLimits = new int[size];
        for (int i = 0; i < size; i++) {
            int horizontalLimit = _grid[i][0];
            for (int j = 1; j < size; j++) {
                horizontalLimit = Math.max(horizontalLimit, _grid[i][j]);
            }
            horizontalLimits[i] = horizontalLimit;
        }
        for (int j = 0; j < size; j++) {
            int verticalLimit = _grid[0][j];
            for (int i = 1; i < size; i++) {
                verticalLimit = Math.max(verticalLimit, _grid[i][j]);
            }
            verticalLimits[j] = verticalLimit;
        }
        int increases = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (_grid[i][j] != horizontalLimits[i] && _grid[i][j] != verticalLimits[j]) {
                    increases += Math.min(horizontalLimits[i], verticalLimits[j]) - _grid[i][j];
                }
            }
        }
        return increases;
    }

}
