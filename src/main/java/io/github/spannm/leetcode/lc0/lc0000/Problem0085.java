package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0085 extends LeetcodeProblem {

    int maximalRectangle(char[][] _matrix) {
        if (_matrix.length == 0) {
            return 0;
        }
        int nbCols = _matrix[0].length;
        int[] left = new int[nbCols];
        int[] right = new int[nbCols];
        int[] height = new int[nbCols];
        Arrays.fill(left, 0);
        Arrays.fill(right, nbCols);
        Arrays.fill(height, 0);
        int maxA = 0;
        for (char[] chars : _matrix) {
            int currLeft = 0;
            int currRight = nbCols;

            for (int j = 0; j < nbCols; j++) {
                if (chars[j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < nbCols; j++) {
                if (chars[j] == '1') {
                    left[j] = Math.max(left[j], currLeft);
                } else {
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            for (int j = nbCols - 1; j >= 0; j--) {
                if (chars[j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = nbCols;
                    currRight = j;
                }
            }

            for (int j = 0; j < nbCols; j++) {
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
            }
        }
        return maxA;
    }

}
