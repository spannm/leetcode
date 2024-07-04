package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2711. Difference of Number of Distinct Values on Diagonals.
 */
class Problem2711 extends LeetcodeProblem {

    int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i;
                int y = j;
                Set<Integer> s = new HashSet<>();
                while (x > 0 && y > 0) {
                    s.add(grid[--x][--y]);
                }
                int tl = s.size();
                x = i;
                y = j;
                s.clear();
                while (x < m - 1 && y < n - 1) {
                    s.add(grid[++x][++y]);
                }
                int br = s.size();
                ans[i][j] = Math.abs(tl - br);
            }
        }
        return ans;
    }

}
