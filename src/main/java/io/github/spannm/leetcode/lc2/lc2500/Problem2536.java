package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2536 extends LeetcodeProblem {

    int[][] rangeAddQueries(int _n, int[][] _queries) {
        int[][] matrix = new int[_n][_n];
        for (int[] query : _queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    matrix[i][j]++;
                }
            }
        }
        return matrix;
    }

}
