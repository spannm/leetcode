package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2661. First Completely Painted Row or Column.
 */
class Problem2661 extends LeetcodeProblem {

    int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> idx = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                idx.put(mat[i][j], new int[] {i, j});
            }
        }
        int[] row = new int[m];
        int[] col = new int[n];
        for (int k = 0;; k++) {
            var x = idx.get(arr[k]);
            int i = x[0];
            int j = x[1];
            row[i]++;
            col[j]++;
            if (row[i] == n || col[j] == m) {
                return k;
            }
        }
    }

}
