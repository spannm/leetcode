package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">74. Search a 2D Matrix</a>.
 */
class Problem0074 extends LeetcodeProblem {

    boolean searchMatrix(int[][] _matrix, int _target) {
        final int rowCount = _matrix.length;
        final int colCount = _matrix[rowCount - 1].length;

        int loRowIdx = 0;
        int hiRowIdx = rowCount - 1;

        while (loRowIdx <= hiRowIdx) {
            int midRowIdx = loRowIdx + hiRowIdx >>> 1;
            int[] midRow = _matrix[midRowIdx];

            if (midRow[colCount - 1] < _target) {
                loRowIdx = midRowIdx + 1;
            } else if (midRow[0] > _target) {
                hiRowIdx = midRowIdx - 1;
            } else {
                // row found
                int loColIdx = 0;
                int hiColIdx = colCount - 1;

                while (loColIdx <= hiColIdx) {
                    int midColIdx = loColIdx + hiColIdx >>> 1;
                    int midVal = midRow[midColIdx];

                    if (midVal < _target) {
                        loColIdx = midColIdx + 1;
                    } else if (midVal > _target) {
                        hiColIdx = midColIdx - 1;
                    } else {
                        return true; // value found in row
                    }
                }
                return false; // value not found in row
            }
        }

        return false;
    }

}
