package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0867 extends LeetcodeProblem {

    int[][] transpose(int[][] _matrix) {
        int[][] result = new int[_matrix[0].length][_matrix.length];
        for (int i = 0; i < _matrix.length; i++) {
            for (int j = 0; j < _matrix[0].length; j++) {
                result[j][i] = _matrix[i][j];
            }
        }
        return result;
    }

}
