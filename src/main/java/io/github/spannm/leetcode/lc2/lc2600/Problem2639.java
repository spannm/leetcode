package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2639. Find the Width of Columns of a Grid.
 */
class Problem2639 extends LeetcodeProblem {

    int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (var row : grid) {
            for (int j = 0; j < n; j++) {
                int w = String.valueOf(row[j]).length();
                ans[j] = Math.max(ans[j], w);
            }
        }
        return ans;
    }

}
