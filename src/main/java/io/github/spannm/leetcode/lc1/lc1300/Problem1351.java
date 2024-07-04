package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/">1351. Count Negative Numbers in a
 * Sorted Matrix</a>.
 */
class Problem1351 extends LeetcodeProblem {

    static int countNegatives(final int[][] _grid) {
        final int colCount = _grid[0].length;
        int count = 0;

        for (int[] ints : _grid) {
            int low = 0;
            int high = colCount - 1;
            int mid;
            while (low <= high) {
                mid = (low + high) / 2;
                if (ints[mid] < 0) {
                    count += high - mid + 1;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return count;
    }

}
