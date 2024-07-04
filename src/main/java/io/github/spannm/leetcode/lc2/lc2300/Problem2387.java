package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2387. Median of a Row Wise Sorted Matrix.
 */
class Problem2387 extends LeetcodeProblem {

    private int[][] grid;

    int matrixMedian(int[][] _grid) {
        grid = _grid;
        int nbRows = _grid.length;
        int nbCols = _grid[0].length;
        int target = nbRows * nbCols + 1 >> 1;
        int left = 0;
        int right = 1000010;
        while (left < right) {
            int mid = left + right >> 1;
            if (count(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int count(int _x) {
        int cnt = 0;
        for (var row : grid) {
            int left = 0;
            int right = row.length;
            while (left < right) {
                int mid = left + right >> 1;
                if (row[mid] > _x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            cnt += left;
        }
        return cnt;
    }

}
