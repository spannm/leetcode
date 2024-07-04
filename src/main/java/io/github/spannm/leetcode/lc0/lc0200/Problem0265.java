package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0265 extends LeetcodeProblem {

    int minCostII(int[][] _costs) {
        if (_costs == null || _costs.length == 0) {
            return 0;
        }

        int nbRows = _costs.length;
        int nbCols = _costs[0].length;

        int min1 = -1;
        int min2 = -1;

        for (int r = 0; r < nbRows; r++) {
            int last1 = min1;
            int last2 = min2;
            min1 = -1;
            min2 = -1;

            for (int c = 0; c < nbCols; c++) {
                if (c != last1) {
                    _costs[r][c] += last1 < 0 ? 0 : _costs[r - 1][last1];
                } else {
                    _costs[r][c] += last2 < 0 ? 0 : _costs[r - 1][last2];
                }

                if (min1 < 0 || _costs[r][c] < _costs[r][min1]) {
                    min2 = min1;
                    min1 = c;
                } else if (min2 < 0 || _costs[r][c] < _costs[r][min2]) {
                    min2 = c;
                }
            }
        }
        return _costs[nbRows - 1][min1];
    }

}
