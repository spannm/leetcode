package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0861 extends LeetcodeProblem {

    int matrixScore(int[][] _arr) {
        int nbRows = _arr.length;
        int nbCols = _arr[0].length;
        for (int r = 0; r < nbRows; r++) {
            if (_arr[r][0] == 0) {
                for (int c = 0; c < nbCols; c++) {
                    if (_arr[r][c] == 0) {
                        _arr[r][c] = 1;
                    } else {
                        _arr[r][c] = 0;
                    }
                }
            }
        }
        for (int c = 1; c < nbCols; c++) {
            int ones = 0;
            for (int[] ints : _arr) {
                if (ints[c] == 1) {
                    ones++;
                }
            }
            if (ones <= nbRows / 2) {
                for (int r = 0; r < nbRows; r++) {
                    if (_arr[r][c] == 1) {
                        _arr[r][c] = 0;
                    } else {
                        _arr[r][c] = 1;
                    }
                }
            }
        }
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int[] ints : _arr) {
            Arrays.stream(ints).forEach(sb::append);
            result += Integer.parseInt(sb.toString(), 2);
            sb.setLength(0);
        }
        return result;
    }

}
