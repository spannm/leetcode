package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1901. Find a Peak Element II.
 */
class Problem1901 extends LeetcodeProblem {

    int[] findPeakGrid(int[][] mat) {
        int l = 0;
        int r = mat.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            int j = maxPos(mat[mid]);
            if (mat[mid][j] > mat[mid + 1][j]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return new int[] {l, maxPos(mat[l])};
    }

    private int maxPos(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[j] < arr[i]) {
                j = i;
            }
        }
        return j;
    }

}
