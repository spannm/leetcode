package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3071. Minimum Operations to Write the Letter Y on a Grid.
 */
class Problem3071 extends LeetcodeProblem {

    int minimumOperationsToWriteY(int[][] _grid) {
        int len = _grid.length;
        int[] cnt1 = new int[3];
        int[] cnt2 = new int[3];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                boolean a = i == j && i <= len / 2;
                boolean b = i + j == len - 1 && i <= len / 2;
                boolean c = j == len / 2 && i >= len / 2;
                if (a || b || c) {
                    cnt1[_grid[i][j]]++;
                } else {
                    cnt2[_grid[i][j]]++;
                }
            }
        }
        int ans = len * len;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    ans = Math.min(ans, len * len - cnt1[i] - cnt2[j]);
                }
            }
        }
        return ans;
    }

}
