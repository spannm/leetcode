package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1267 extends LeetcodeProblem {

    int countServers(int[][] _grid) {
        int m = _grid.length;
        int n = _grid[0].length;
        int[] rowCount = new int[m];
        int[] columnCount = new int[n];
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (_grid[i][j] == 1) {
                    rowCount[i]++;
                    columnCount[j]++;
                    total++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (_grid[i][j] == 1 && rowCount[i] == 1 && columnCount[j] == 1) {
                    total--;
                }
            }
        }
        return total;
    }

}
