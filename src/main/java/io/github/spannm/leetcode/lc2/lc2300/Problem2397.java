package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2397. Maximum Rows Covered by Columns.
 */
class Problem2397 extends LeetcodeProblem {

    int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    rows[i] |= 1 << j;
                }
            }
        }
        int ans = 0;
        for (int mask = 1; mask < 1 << n; ++mask) {
            if (Integer.bitCount(mask) != numSelect) {
                continue;
            }
            int t = 0;
            for (int x : rows) {
                if ((x & mask) == x) {
                    t++;
                }
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

}
