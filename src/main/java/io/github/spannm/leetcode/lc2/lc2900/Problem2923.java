package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2923. Find Champion I.
 */
class Problem2923 extends LeetcodeProblem {

    int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0;; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] == 1) {
                    cnt++;
                }
            }
            if (cnt == n - 1) {
                return i;
            }
        }
    }

}
