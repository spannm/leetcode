package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2371. Minimize Maximum Value in a Grid.
 */
class Problem2371 extends LeetcodeProblem {

    int[][] minScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> nums = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums.add(new int[] {grid[i][j], i, j});
            }
        }
        nums.sort(Comparator.comparingInt(a -> a[0]));
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        int[][] ans = new int[m][n];
        for (int[] num : nums) {
            int i = num[1];
            int j = num[2];
            ans[i][j] = Math.max(rowMax[i], colMax[j]) + 1;
            rowMax[i] = ans[i][j];
            colMax[j] = ans[i][j];
        }
        return ans;
    }

}
